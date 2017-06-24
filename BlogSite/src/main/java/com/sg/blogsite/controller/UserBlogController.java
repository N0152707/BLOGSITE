/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.controller;

import com.sg.blogsite.model.UserBlog;
import com.sg.blogsite.service.UserBlogServiceLayer;
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

/**
 *
 * @author apprentice
 */
@Controller
public class UserBlogController {

    private UserBlogServiceLayer service;

    @Inject
    public UserBlogController(UserBlogServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/addUserBlog", method = RequestMethod.POST)
    public String addUserBlog(HttpServletRequest request) {
        UserBlog userBlog = new UserBlog();
        userBlog.setUserBlogName("userBlogName");
        userBlog.setUserBlogPassword("userBlogPassword");
        service.createUserBlog(userBlog);
        userBlog.setUserBlogId(userBlog.getUserBlogId());
        return "userBlog";
    }

    @RequestMapping(value = "/deleteUserBlog", method = RequestMethod.GET)
    public String deleteUserBlog(HttpServletRequest request) {
        String userBlogIdParameter = request.getParameter("userBlogId");
        int userBlogId = Integer.parseInt(userBlogIdParameter);
        service.deleteUserBlog(userBlogId);
        return ""; //what page do I return to?
    }

    @RequestMapping(value = "/getUserBlogById", method = RequestMethod.GET)
    public String getUserBlogById(HttpServletRequest request) {
        String userBlogIdParameter = request.getParameter("userBlogId");
        int userBlogId = Integer.parseInt(userBlogIdParameter);
        service.getUserBlogById(userBlogId);
        return "userBlog";
    }

    @RequestMapping(value = "/getAllUserBlogs", method = RequestMethod.GET)
    public String getAllUserBlogsByCategory(HttpServletRequest request, Model model) {
        List<UserBlog> userBlogList = service.getAllUserBlogs();
        // Put the List of tags on the Model
        model.addAttribute("userBlogList", userBlogList);
        // Return the logical name of our View component
        return "userBlog";
    }

    @RequestMapping(value = "/editUserBlog", method = RequestMethod.POST)
    public String editUserBlog(@Valid @ModelAttribute("userBlog") UserBlog userBlog,
            BindingResult result) {
        if (result.hasErrors()) {
            return "displayUserBlogForm";  //where do I return?
        }
        service.updateUserBlog(userBlog);
        return "redirect:displayUserBlogsPage";  //where does this go?
    }

}
