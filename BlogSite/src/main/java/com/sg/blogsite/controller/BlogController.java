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
public class BlogController {

    private BlogServiceLayer service;
    private CategoryServiceLayer catService;
    String categorySelected = "Most Recent Posts";

    @Inject
    public BlogController(BlogServiceLayer service, CategoryServiceLayer catService) {
        this.service = service;
        this.catService = catService;
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        List<Blog> blogList = service.getLastFiveBlogs();
        model.addAttribute("blogList", blogList);
        getAllCategories(model);
        model.addAttribute("categorySelected", categorySelected);
        return "index";
    }

    @RequestMapping(value = "/getAllBlogsByCategory", method = RequestMethod.GET)
    public String getAllBlogsByCategory(HttpServletRequest request, Model model) {
        String categoryIdParameter = request.getParameter("selectedCat");
        int categoryId = Integer.parseInt(categoryIdParameter);
        Category category = catService.readCategory(categoryId);
        categorySelected = category.getCategoryName();
        List<Blog> blogList = service.getAllBlogsByCategory(categoryId);
        model.addAttribute("blogList", blogList);
        getAllCategories(model);
        model.addAttribute("categorySelected", categorySelected);
        return "index";
    }

    @RequestMapping(value = "getAllCategories", method = RequestMethod.GET)
    public List<Category> getAllCategories(Model model) {
        List<Category> categoryList = catService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return categoryList;
    }

}
