/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.CategoryDao;
import com.sg.blogsite.model.Category;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class CategoryServiceLayerImpl implements CategoryServiceLayer {

    CategoryDao categorydao;

    public CategoryServiceLayerImpl(CategoryDao dao) {
        this.categorydao = dao;
    }

    @Override
    public Category createCategory(Category category) {
        categorydao.createCategory(category);
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        categorydao.updateCategory(category);
    }

    @Override
    public Category readCategory(int categoryId) {
        return categorydao.readCategory(categoryId);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categorydao.removeCategory(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categorydao.getAllCategories();
    }

}
