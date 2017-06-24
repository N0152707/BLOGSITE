/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class UserBlogDaoTest {

    private UserBlogDao userblogdao;

    public UserBlogDaoTest() {
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
        userblogdao = ctx.getBean("userBlogDao", UserBlogDao.class);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUserBlogById method, of class UserBlogDao.
     */
    @Test
    public void testGetUserBlogById() {
        ///arrange
        ///act
        ///assert
    }

}
