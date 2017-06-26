/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.controller;

import com.sg.blogsite.model.Tag;
import com.sg.blogsite.service.TagServiceLayer;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class TagController {

    private TagServiceLayer service;

    @Inject
    public TagController(TagServiceLayer service) {
        this.service = service;
    }

//    @RequestMapping(value = "/addTag", method = RequestMethod.POST)
//    public String addTag(HttpServletRequest request) {
//        String blogIdParameter = request.getParameter("blogId");
//        int blogId = Integer.parseInt(blogIdParameter);
//        Tag tag = new Tag();
//        tag.setTagName("tagName");
//        service.createTag(tag, blogId);
//        tag.setTagId(tag.getTagId());
//        return "tag";
//    }
    @RequestMapping(value = "/deleteTag", method = RequestMethod.GET)
    public String deleteTag(HttpServletRequest request) {
        String tagIdParameter = request.getParameter("tagId");
        int tagId = Integer.parseInt(tagIdParameter);
        service.deleteTag(tagId);
        return "";
    }

    @RequestMapping(value = "/getTagById", method = RequestMethod.GET)
    public String getTagById(HttpServletRequest request) {
        String tagIdParameter = request.getParameter("tagId");
        int tagId = Integer.parseInt(tagIdParameter);
        service.readTag(tagId);
        return "tag";
    }

    @RequestMapping(value = "/getAlltags", method = RequestMethod.GET)
    public String getAllTagsByCategory(HttpServletRequest request, Model model) {
        List<Tag> tagList = service.getAllTags();
        // Put the List of tags on the Model
        model.addAttribute("tagList", tagList);
        // Return the logical name of our View component
        return "tag";
    }

    @RequestMapping(value = "/getAllTagsInABlog", method = RequestMethod.GET)
    public String getAllTagsInABlog(HttpServletRequest request, Model model) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        List<Tag> blogList = service.getAllTagsInABlog(blogId);
        // Put the List of blogs on the Model
        model.addAttribute("blogList", blogList);
        // Return the logical name of our View component
        return "tag";

    }
}
