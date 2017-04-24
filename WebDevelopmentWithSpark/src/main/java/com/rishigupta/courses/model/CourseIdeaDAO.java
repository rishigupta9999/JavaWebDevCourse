package com.rishigupta.courses.model;

import java.util.List;

/**
 * Created by rigupta on 4/23/17.
 */
public interface CourseIdeaDAO {

    boolean add(CourseIdea idea);

    List<CourseIdea> findAll();

    CourseIdea findBySlug(String slug);
}
