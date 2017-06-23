/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.CategoryDao;
import com.sg.blogsite.model.Category;

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
    public Category getCategoryById(int categoryId) {
        return categorydao.getCategoryById(categoryId);
    }

}
