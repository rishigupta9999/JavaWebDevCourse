package com.teamtreehouse.suppresswarnings;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Post {
    private String title;
    private String subtitle;
    private Date dateCreated;
    private Date datePublished;
    private List<Comment> comments;

    public Post(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
        dateCreated = new Date();
        datePublished = null;
        comments = new ArrayList<Comment>();
    }

    /**
     * @return Line-separated title, subtitle and date published (or date created if not published)
     */
    public String toString() {
        String dateType = "";
        Date date = null;
        if(datePublished == null) {
            dateType = "Created";
            date = dateCreated;
        } else {
            dateType = "Published";
            date = datePublished;
        }
        return String.format("%s%n%s%n%s on %4$ta, %4$te %4$tb %4$tY",title,subtitle,dateType,date);
    }
    
    public String getTitle() {
        return title;
    }
}