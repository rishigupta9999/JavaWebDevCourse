package com.teamtreehouse.suppresswarnings;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    public static List<Post> getLatestPosts(int howMany) {
        // TODO: Fetch & return howMany most recent blog posts
        List<Post> posts = new ArrayList<Post>();
        if(howMany == 1) {
            posts.add(new Post("Lorem Ipsum","Placeholder text"));
        }
        return posts;
    }
}