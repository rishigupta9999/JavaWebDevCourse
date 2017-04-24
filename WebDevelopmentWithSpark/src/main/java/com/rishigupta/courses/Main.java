package com.rishigupta.courses;

import static spark.Spark.*;

import com.rishigupta.courses.model.SimpleCourseIdeaDAO;
import com.rishigupta.courses.model.CourseIdeaDAO;
import com.rishigupta.courses.model.CourseIdea;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by rigupta on 4/16/17.
 */
public class Main {
    public static void main(String[] args)  {
        staticFileLocation("/public");

        CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

        before ((req, res) -> {
            if (req.cookie("username") != null)
            {
                req.attribute("username", req.cookie("username"));
            }
        });

        before("/ideas", (req, res) -> {
            if (req.attribute("username") == null) {
                res.redirect("/");
                halt();
            }
        });

        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.attribute("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/ideas", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("ideas", dao.findAll());

            return new ModelAndView(model, "ideas.hbs");
        }, new HandlebarsTemplateEngine());

        post("/ideas", (req, res) -> {
            String title = req.queryParams("title");

            CourseIdea idea = new CourseIdea(title, req.attribute("username"));
            dao.add(idea);

            res.redirect("/ideas");

            return null;
        });

        post("sign-in", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            res.cookie("username", username);

            res.redirect("/");

            return null;
        });
    }
}
