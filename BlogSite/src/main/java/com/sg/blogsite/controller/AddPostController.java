package com.sg.blogsite.controller;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.model.Category;
import com.sg.blogsite.model.Tag;
import com.sg.blogsite.service.BlogServiceLayer;
import com.sg.blogsite.service.CategoryServiceLayer;
import com.sg.blogsite.service.TagServiceLayer;
import java.time.LocalDate;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPostController {

    private BlogServiceLayer blogService;
    private CategoryServiceLayer catService;
    private TagServiceLayer tagService;

    @Inject
    public AddPostController(BlogServiceLayer blogService, CategoryServiceLayer catService, TagServiceLayer tagService) {
        this.blogService = blogService;
        this.catService = catService;
        this.tagService = tagService;
    }

    @RequestMapping(value = "/displayAddPost", method = RequestMethod.GET)
    public String displayAddPost(Model model) {
        model.addAttribute("blog", blogService.readBlog(12));

        return "addPost";
    }

    @RequestMapping(value = "/createBlog", method = RequestMethod.POST)
    public String addBlog(HttpServletRequest request) {
        Blog blog = new Blog();
        blog.setBlogPublished("N");
        blog.setBlogDatePublished(LocalDate.now());  //user has to enter the date as 2017-02-28
        blog.setBlogTitle(request.getParameter("blogTitle"));
        blog.setBlogArticle(request.getParameter("blogArticle"));
        blog.setBlogDeleted("N");
        blog.setUserBlogUserBlogId(Integer.parseInt(request.getParameter("userBlogId")));
        blog.setCategoryCategoryId(Integer.parseInt(request.getParameter("categoryId")));
        blogService.createBlog(blog);
        return "redirect:index";
    }

    public String addTag(HttpServletRequest request) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        Tag tag = new Tag();
        tag.setTagName("tagName");
        tagService.createTag(tag, blogId);
        tag.setTagId(tag.getTagId());
        return "tag";
    }

    public String addCategory(HttpServletRequest request) {
        // grab the incoming values from the form and create a new object
        Category category = new Category();
        category.setCategoryName("categoryName");
        catService.createCategory(category);
        return "redirect:displayCategoriesPage";
    }

}
