package com.sg.blogsite.controller;

import com.sg.blogsite.model.Category;
import com.sg.blogsite.service.CategoryServiceLayer;
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
public class CategoryController {

    private CategoryServiceLayer service;

    @Inject
    public CategoryController(CategoryServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/displayCategoriesPage", method = RequestMethod.GET)
    public String displayCategoriesPage(Model model) {
        List<Category> categoryList = service.getAllCategories();
        model.addAttribute("categoryList", categoryList);
        return "category";
    }
//
//    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
//    public String addCategory(HttpServletRequest request) {
//        // grab the incoming values from the form and create a new object
//        Category category = new Category();
//        category.setCategoryName("categoryName");
//        service.createCategory(category);
//        return "redirect:displayCategoriesPage";
//    }

    public String addCategory(HttpServletRequest request) {
        // grab the incoming values from the form and create a new object
        Category category = new Category();
        category.setCategoryName("categoryName");
        service.createCategory(category);
        return "category";
    }

    @RequestMapping(value = "/editCategoryForm", method = RequestMethod.GET)
    public String displayEditCategoryForm(HttpServletRequest request, Model model) {
        String categoryIdParameter = request.getParameter("categoryId");
        int categoryId = Integer.parseInt(categoryIdParameter);
        Category category = service.readCategory(categoryId);
        model.addAttribute("category", category);
        return "editCategoryForm";
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.POST)
    public String editCategory(@Valid @ModelAttribute("category") Category category,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editCategoryForm";
        }
        service.updateCategory(category);
        return "category";
    }
    //MOVED TO EDITPOST CONTROLLE
//    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
//    public String deleteCategory(HttpServletRequest request) {
//        String categoryIdParameter = request.getParameter("categoryId");
//        int categoryId = Integer.parseInt(categoryIdParameter);
//        service.deleteCategory(categoryId);
//        return "";
//    }

}
