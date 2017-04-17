package com.rishigupta.courses;

import static spark.Spark.*;

/**
 * Created by rigupta on 4/16/17.
 */
public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
