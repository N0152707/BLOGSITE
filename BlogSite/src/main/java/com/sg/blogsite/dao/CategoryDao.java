/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

/**
 *
 * @author apprentice
 */
public interface CategoryDao {

    public Category addCategory(Category category);

//    public void removeCategory(int categoryId);
    public void updateCategory(Category category);

//    public List<Category> getAllCategories();
    public Category getCategoryById(int categoryId);

}
