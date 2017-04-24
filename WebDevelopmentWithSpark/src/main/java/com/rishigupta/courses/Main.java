package com.rishigupta.courses;

import static spark.Spark.*;

import com.rishigupta.courses.model.SimpleCourseIdeaDAO;
import com.rishigupta.courses.model.CourseIdeaDAO;
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

        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("sign-in", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            res.cookie("username", username);

            model.put("username", username);

            return new ModelAndView(model, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
