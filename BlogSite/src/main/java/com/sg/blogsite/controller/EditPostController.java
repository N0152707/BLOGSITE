/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.controller;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.model.Category;
import com.sg.blogsite.model.Tag;
import com.sg.blogsite.service.BlogServiceLayer;
import com.sg.blogsite.service.CategoryServiceLayer;
import com.sg.blogsite.service.TagServiceLayer;
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
public class EditPostController {

    private TagServiceLayer tagService;
    private CategoryServiceLayer categoryService;
    private BlogServiceLayer blogService;

    @Inject
    public EditPostController(CategoryServiceLayer categoryService, TagServiceLayer tagService, BlogServiceLayer blogService) {
        this.categoryService = categoryService;
        this.tagService = tagService;
        this.blogService = blogService;
    }

    @RequestMapping(value = "/addTagPost", method = RequestMethod.POST)
    public String addTag(HttpServletRequest request) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        Tag tag = new Tag();
        tag.setTagName("tagName");
        tagService.createTag(tag, blogId);
        tag.setTagId(tag.getTagId());
        return "tag";
    }

    @RequestMapping(value = "/deleteTag", method = RequestMethod.GET)
    public String deleteTag(HttpServletRequest request) {
        String tagIdParameter = request.getParameter("tagId");
        int tagId = Integer.parseInt(tagIdParameter);
        tagService.deleteTag(tagId);
        return "";
    }

    @RequestMapping(value = "/addCategoryPost", method = RequestMethod.POST)
    public String addCategory(HttpServletRequest request) {
        // grab the incoming values from the form and create a new object
        Category category = new Category();
        category.setCategoryName("categoryName");
        categoryService.createCategory(category);
        return "redirect:displayCategoriesPage";
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(HttpServletRequest request) {
        String categoryIdParameter = request.getParameter("categoryId");
        int categoryId = Integer.parseInt(categoryIdParameter);
        categoryService.deleteCategory(categoryId);
        return "redirect:displayContactsPage";
    }

    @RequestMapping(value = "/editBlogForm", method = RequestMethod.GET)
    public String displayEditBlogForm(HttpServletRequest request, Model model) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        Blog blog = blogService.readBlog(blogId);

        model.addAttribute("blog", blogService.readBlog(blogId));
        return "editPost";
    }
}
