package com.sg.blogsite.controller;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.model.Category;
import com.sg.blogsite.service.BlogServiceLayer;
import com.sg.blogsite.service.CategoryServiceLayer;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditPageControllerTEMPORARY {

    private BlogServiceLayer service;
    private CategoryServiceLayer catService;
    String categorySelected = "Most Recent Posts";

    @Inject
    public EditPageControllerTEMPORARY(BlogServiceLayer service, CategoryServiceLayer catService) {
        this.service = service;
        this.catService = catService;
    }

    @RequestMapping(value = {"editPage", "/editPage.jsp"}, method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        List<Blog> blogList = service.getLastFiveBlogs();
        model.addAttribute("blogList", blogList);
        List<Category> categoryList = catService.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("categorySelected", categorySelected);
        return "editPage";
    }
}
