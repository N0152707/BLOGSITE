/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Blog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BlogDaoFileImpl {

    private Map<String, Blog> blogs = new HashMap<>();

    public static final String STATICPAGES_FILE = "staticpages.txt";
    public static final String DELIMETER = "::";

    public List<Blog> getAllBlogs() /* throws
            StaticPagesDaoPersistenceException*/ {
        loadBlogs();
        return new ArrayList<Blog>(blogs.values());
    }

    private void loadBlogs() /*throws StaticPagesDaoPersistenceException*/ {
        //create scanner for reading the file
        Scanner scanner = null;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(STATICPAGES_FILE)));
        } catch (FileNotFoundException e) {
            /* throw new StaticPagesDaoPersistenceException("Could not load file into memory.");*/
        }
        String currentLine;
        String[] currentTokens;
        int currentBlogInt;
        LocalDate lDate;

        //Add a try ***********************************************
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMETER);

            //Blog currentBlog = new Blog(currentTokens[0]);
            //convert token to an int
            Blog currentBlog = new Blog();
            currentBlogInt = new Integer(Integer.parseInt(currentTokens[0]));
            currentBlog.setBlogId(currentBlogInt);
            currentBlog.setBlogPublished(currentTokens[1]);
            currentBlog.setBlogDeleted(currentTokens[2]);
            lDate = LocalDate.parse(currentTokens[3]);
            currentBlog.setBlogDatePublished(lDate);
//            currentBlog.setBlogTitle = currentTokens[4];
//            currentBlog.setBlogArticle = currentTokens[5];

//            blogs.put(currentBlog.getBlogId(), currentBlog);
        }
    }

    private void writeBlogs() /* throws StaticPageDaoPersistenceException*/ {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(STATICPAGES_FILE));
        } catch (IOException e) {
            /*throw new StaticPageDaoPersistenceException(
                    "could not save vending machine data.", e);*/
        }

        /*        List<Blog> blogList = this.getAllBlogs();
        for (Blog currentBlog : blogList) {
            out.println(currentBlog.getBlogId() + DELIMETER
                    + currentBlog.getPublished() + DELIMETER
                    + currentBlog.getDeleted() + DELIMETER
                    + currentBlog.getDatePublished() + DELIMETER
                    + currentBlog.getTitle() + DELIMETER
                    + currentBlog.getArticle());
            out.flush();
        }
        // Clean up
        out.close();

    }
         */
    }
}
