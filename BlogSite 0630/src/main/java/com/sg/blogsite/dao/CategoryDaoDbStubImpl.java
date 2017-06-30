/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class CategoryDaoDbStubImpl implements CategoryDao {

    private Category onlyCategory;
    private List<Category> categoryList = new ArrayList<>();

    public CategoryDaoDbStubImpl() {
        onlyCategory = new Category();
        onlyCategory.setCategoryName("Category Scary");

        categoryList.add(onlyCategory);

    }

    @Override
    public Category createCategory(Category category) {
        if (category.getCategoryName().equals(onlyCategory.getCategoryName())) {
            return onlyCategory;
        } else {
            return null;
        }
    }

    @Override
    public Category readCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> getAllCategories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
