package com.sg.blogsite.controller;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.model.Category;
import com.sg.blogsite.model.UserBlog;
import com.sg.blogsite.service.BlogServiceLayer;
import com.sg.blogsite.service.CategoryServiceLayer;
import com.sg.blogsite.service.TagServiceLayer;
import com.sg.blogsite.service.UserBlogServiceLayer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPostController {

    private BlogServiceLayer blogService;
    private CategoryServiceLayer catService;
    private TagServiceLayer tagService;
    private UserBlogServiceLayer userService;
    private int currentUserId = 1;

    @Inject
    public AddPostController(BlogServiceLayer blogService, CategoryServiceLayer catService, TagServiceLayer tagService, UserBlogServiceLayer userService) {
        this.blogService = blogService;
        this.catService = catService;
        this.tagService = tagService;
        this.userService = userService;
    }

    @RequestMapping(value = "/displayAddPost", method = RequestMethod.GET)
    public String displayAddPost(Model model) {
        model.addAttribute("blog", blogService.readBlog(0));
        UserBlog currentUser = userService.getUserBlogById(currentUserId);
        model.addAttribute("userId", currentUserId);
        model.addAttribute("firstName", currentUser.getUserBlogFirstName());
        model.addAttribute("lastName", currentUser.getUserBlogLastName());
        model.addAttribute("blog", new Blog());
        return "addPost";
    }

    @RequestMapping(value = "/createBlog", method = RequestMethod.POST)
    public String addBlog(@ModelAttribute("blog") Blog updateBlog, Model model, BindingResult result) {
        blogService.createBlog(updateBlog, currentUserId);
        return "addPost";
    }

    @RequestMapping(value = "/addTags", method = RequestMethod.POST)
    public void addTags(HttpServletRequest request) {
        List<String> tagList = new ArrayList();
        String tag1 = request.getParameter("tagName1");
        String tag2 = request.getParameter("tagName2");
        String tag3 = request.getParameter("tagName3");
        String tag4 = request.getParameter("tagName4");
        tagList.add(tag1);
        tagList.add(tag2);
        tagList.add(tag3);
        tagList.add(tag4);
        tagService.addTagsToBridge(tagList);
    }

//    @RequestMapping(value = "/addNewPostWithTags", method = RequestMethod.POST)
//    public String addPostWithTags(ModelMap map) {
//        Blog newPost = new Blog();
//        List<Tag> tagList = new ArrayList();
//        map.addAttribute("newPost", newPost);
//        map.addAttribute("tagList", tagList);
//        return "displayAddPost";
//    }
//    public String addTag(HttpServletRequest request) {
//        String blogIdParameter = request.getParameter("blogId");
//        int blogId = Integer.parseInt(blogIdParameter);
//        Tag tag = new Tag();
//        tag.setTagName("tagName");
//        tagService.createTag(tag, blogId);
//        tag.setTagId(tag.getTagId());
//        return "tag";
//    }
    public String addCategory(HttpServletRequest request) {
        // grab the incoming values from the form and create a new object
        Category category = new Category();
        category.setCategoryName("categoryName");
        catService.createCategory(category);
        return "redirect:displayCategoriesPage";
    }

}
