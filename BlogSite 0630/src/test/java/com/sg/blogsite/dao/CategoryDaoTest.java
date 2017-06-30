/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Category;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class CategoryDaoTest {

    private CategoryDao categorydao;

    public CategoryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        categorydao = ctx.getBean("categoryDao", CategoryDao.class);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addCategory method and getCategoryById method, of class
     * CategoryDao.
     */
    @Test
    public void testAddCategory() {
        Category newCategory1 = new Category();
        newCategory1.setCategoryName("Healthy Living");
        categorydao.createCategory(newCategory1);
        Category fromDb = categorydao.readCategory(newCategory1.getCategoryId());
        Assert.assertEquals(fromDb, newCategory1);
    }

    /**
     * Test of updateCategory method, of class CategoryDao.
     */
    @Test
    public void testUpdateCategory() {
        Category newCategory2 = new Category();
        newCategory2.setCategoryName("Healthy Living");
        categorydao.createCategory(newCategory2);
        newCategory2.setCategoryName("Health and Fitness");
        categorydao.updateCategory(newCategory2);
        Category fromDb = categorydao.readCategory(newCategory2.getCategoryId());
        assertEquals(fromDb, newCategory2);
    }

}
