/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.model.Category;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface CategoryServiceLayer {

    public Category createCategory(Category category);

    public Category readCategory(int categoryId);

    public void updateCategory(Category category);

    public void deleteCategory(int categoryId);

    public List<Category> getAllCategories();

}
