/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.controller;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.model.Category;
import com.sg.blogsite.service.BlogServiceLayer;
import com.sg.blogsite.service.CategoryServiceLayer;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {

    private BlogServiceLayer service;
    private CategoryServiceLayer catService;
//    Blog blog;

    @Inject
    public BlogController(BlogServiceLayer service, CategoryServiceLayer catService) {
        this.service = service;
        this.catService = catService;
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String displayFrontPage(Model model) {
        List<Blog> blogList = service.getLastFiveBlogs();
        model.addAttribute("blogList", blogList);
        // Return the logical name of our View component
        return "index";
    }

    @RequestMapping(value = "/displayBlogPosts", method = RequestMethod.GET)
    public String displayBlogPosts(Model model) {
        List<Blog> blogList = service.getLastFiveBlogs();
        model.addAttribute("blogList", blogList);
        // Return the logical name of our View component
        return "blog";
    }

    @RequestMapping(value = "/addBlog", method = RequestMethod.POST)
    public String addBlog(HttpServletRequest request) {
        Blog blog = new Blog();
        blog.setBlogPublished("N");
        blog.setBlogDatePublished(LocalDate.parse("blogDate"));  //user has to enter the date as 2017-02-28
        blog.setBlogTitle("blogTitle");
        blog.setBlogArticle("blogArticle");
        blog.setBlogDeleted("N");
        service.createBlog(blog);
        return "redirect:displayBlogsPage";
    }

    @RequestMapping(value = "/editBlogForm", method = RequestMethod.GET)
    public String displayEditBlogForm(HttpServletRequest request, Model model) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        Blog blog = service.readBlog(blogId);

        model.addAttribute("blog", blog);
        return "editPost";
    }

    public String getAllBlogsByCategory(HttpServletRequest request, Model model) {
        String categoryIdParameter = request.getParameter("categoryId");
        int categoryId = Integer.parseInt(categoryIdParameter);
        List<Blog> blogList = service.getAllBlogsByCategory(categoryId);
        model.addAttribute("blogList", blogList);
        return "redirect:displayBlogsPage";
    }

    @RequestMapping(value = "getAllCategories", method = RequestMethod.GET)
    public List<Category> getAllCategories(Model model) {
        List<Category> categoryList = catService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return categoryList;
    }

}
