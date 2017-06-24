/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.controller;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.service.BlogServiceLayer;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {

    private BlogServiceLayer service;

    @Inject
    public BlogController(BlogServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = {"/BlogSite", "/", "/index.jsp"}, method = RequestMethod.GET)
    public String displayBlogsPage(Model model) {
        // Get all the blogs from the get last 5 method
        // List<Blog> blogList = service.getLastFiveBlogs();
        // Put the List of blogs on the Model
        //model.addAttribute("blogList", blogList);
        // Return the logical name of our View component
        return "blogSite";
    }

    //i don't think we need a addBlogForm in here, that is initially just displayed as an empty page to be filled in
    @RequestMapping(value = "/addBlog", method = RequestMethod.POST)
    public String addBlog(HttpServletRequest request) {
        // grab the incoming values from the form and create a newblog
        // object
        Blog blog = new Blog();
        blog.setBlogPublished("N");
        blog.setBlogDatePublished(null);  //don't know how to parse a date from a string here
        blog.setBlogTitle("blogTitle");
        blog.setBlogArticle("blogArticle");
        blog.setBlogDeleted("N");

        // persist the new Contact
        service.createBlog(blog);

        // we don't want to forward to a View component - we want to
        // redirect to the endpoint that displays the Contacts Page
        // so it can display the new Contact in the table.
        return "redirect:displayBlogsPage";
    }

    @RequestMapping(value = "/editBlogForm", method = RequestMethod.GET)
    public String displayEditBlogForm(HttpServletRequest request, Model model) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        Blog blog = service.readBlog(blogId);
        model.addAttribute("blog", blog);
        return "editBlogForm";
    }

    @RequestMapping(value = "/editBlog", method = RequestMethod.POST)
    public String editBlog(@Valid @ModelAttribute("blog") Blog blog,
            BindingResult result) {

        if (result.hasErrors()) {
            return "editBlogForm";
        }

        service.updateBlog(blog);

        return "redirect:displayBlogsPage";
    }

    @RequestMapping(value = "/getAllBlogsByCategory", method = RequestMethod.GET)
    public String getAllBlogsByCategory(HttpServletRequest request, Model model) {
        String categoryIdParameter = request.getParameter("categoryId");
        int categoryId = Integer.parseInt(categoryIdParameter);

        List<Blog> blogList = service.getAllBlogsByCategory(categoryId);

        // Put the List of blogs on the Model
        model.addAttribute("blogList", blogList);

        // Return the logical name of our View component
        return "blog";

    }
}
