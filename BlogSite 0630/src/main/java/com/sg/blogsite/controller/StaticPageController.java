/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.controller;

import com.sg.blogsite.model.BlogStatic;
import com.sg.blogsite.service.BlogStaticServiceLayer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class StaticPageController {

    private BlogStaticServiceLayer blogStaticService;

    @Inject
    public StaticPageController(BlogStaticServiceLayer blogStaticService) {
        this.blogStaticService = blogStaticService;
    }

    @RequestMapping(value = "/displayAddStaticPost", method = RequestMethod.GET)
    public String displayAddStaticPost() {
        return "addStaticPost";
    }

    @RequestMapping(value = "/createStaticBlog", method = RequestMethod.POST)
    public String addStaticBlog(HttpServletRequest request) {
        BlogStatic blogstatic = new BlogStatic();
        blogstatic.setBlogStaticArticle(request.getParameter("blogStaticArticle"));
        blogstatic.setBlogStaticTitle(request.getParameter("blogStaticTitle"));
        blogStaticService.createStaticBlog(blogstatic);
        return "addStaticPost";

    }
}
