package com.sg.blogsite.controller;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.model.Category;
import com.sg.blogsite.service.BlogServiceLayer;
import com.sg.blogsite.service.CategoryServiceLayer;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublishDeleteController {

    private BlogServiceLayer blogService;
    private CategoryServiceLayer catService;
    String categorySelected = "Most Recent Posts";

    @Inject
    public PublishDeleteController(BlogServiceLayer blogService, CategoryServiceLayer catService) {
        this.blogService = blogService;
        this.catService = catService;
    }

    @RequestMapping(value = "/displayPublishDelete", method = RequestMethod.GET)
    public String displayPublishDelete(Model model) {
        List<Blog> blogList = blogService.getLastFiveBlogs();
        model.addAttribute("blogList", blogList);
        getAllCategoriesPublishDelete(model);
        model.addAttribute("categorySelected", categorySelected);
        return "publishDelete";
    }

    @RequestMapping(value = "/getAllBlogsByCategoryPublishDelete", method = RequestMethod.GET)
    public String getAllBlogsByCategoryPublishDelete(HttpServletRequest request, Model model) {
        String categoryIdParameter = request.getParameter("selectedCat");
        int categoryId = Integer.parseInt(categoryIdParameter);
        Category category = catService.readCategory(categoryId);
        categorySelected = category.getCategoryName();
        List<Blog> blogList = blogService.getAllBlogsByCategory(categoryId);
        model.addAttribute("blogList", blogList);
        getAllCategoriesPublishDelete(model);
        model.addAttribute("categorySelected", categorySelected);
        return "publishDelete";
    }

    @RequestMapping(value = "/getAllCategoriesPublishDelete", method = RequestMethod.GET)
    public List<Category> getAllCategoriesPublishDelete(Model model) {
        List<Category> categoryList = catService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return categoryList;
    }

    @RequestMapping(value = "/updateDelete", method = RequestMethod.GET)
    public String updateDelete(HttpServletRequest request, Model model, String update) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        Blog blog = blogService.readBlog(blogId);
        blog.setBlogDeleted("Y");
        blog.setBlogPublished("N");
        blogService.updateBlog(blog);
        displayPublishDelete(model);
        return "publishDelete";
    }

    @RequestMapping(value = "/updatePublish", method = RequestMethod.GET)
    public String updatePublish(HttpServletRequest request, Model model, String update) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        Blog blog = blogService.readBlog(blogId);
        blog.setBlogPublished("Y");
        blog.setBlogDeleted("N");
        blogService.updateBlog(blog);
        displayPublishDelete(model);
        return "/publishDelete";
    }

    @RequestMapping(value = "/updateRecover", method = RequestMethod.GET)
    public String updateRecover(HttpServletRequest request, Model model, String update) {
        String blogIdParameter = request.getParameter("blogId");
        int blogId = Integer.parseInt(blogIdParameter);
        Blog blog = blogService.readBlog(blogId);
        blog.setBlogDeleted("N");
        blogService.updateBlog(blog);
        displayPublishDelete(model);
        return "publishDelete";
    }

}
