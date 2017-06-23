/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Category;
import java.util.List;

public interface CategoryDao {

    public Category createCategory(Category category);

    public Category readCategory(int categoryId);

    public void updateCategory(Category category);

    public List<Category> getAllCategories();

    public void removeCategory(int categoryId);

}
