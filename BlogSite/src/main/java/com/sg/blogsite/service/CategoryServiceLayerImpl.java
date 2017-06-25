package com.sg.blogsite.service;

import com.sg.blogsite.dao.CategoryDao;
import com.sg.blogsite.model.Category;
import java.util.List;

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
        categorydao.deleteCategory(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categorydao.getAllCategories();
    }

}
