/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author apprentice
 */
@Controller
public class CategoryController {

    private CategoryServiceLayer service;

    @Inject
    public CategoryController(CategoryServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/displayCategoriesPage", method = RequestMethod.GET)
    public String displayCategoriesPage(Model model) {
        // Get all the categories
        List<Category> categoryList = service.getAllCategories();

        model.addAttribute("categoryList", categoryList);

        // Return the logical name of our View component
        return "category";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(HttpServletRequest request) {
        // grab the incoming values from the form and create a new object
        Category category = new Category();
        category.setCategoryName("categoryName");

        // persist the new Contact
        service.createCategory(category);

        // we don't want to forward to a View component - we want to
        // redirect to the endpoint that displays the Contacts Page
        // so it can display the new Contact in the table.
        return "redirect:displayCategoriesPage";
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

        return "redirect:displayCategoriesPage";
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(HttpServletRequest request) {
        String categoryIdParameter = request.getParameter("categoryId");
        int categoryId = Integer.parseInt(categoryIdParameter);
        service.deleteCategory(categoryId);
        return "redirect:displayContactsPage";
    }

}
