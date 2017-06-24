/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.model.Role;
import com.sg.blogsite.model.Tag;
import java.time.LocalDate;
import java.util.List;
import javax.management.relation.RoleList;
import org.junit.After;
import org.junit.AfterClass;
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
public class RoleDaoTest {

      private RoleDao roledao;
    
    public RoleDaoTest() {
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
        roledao = ctx.getBean("roleDao", RoleDao.class);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllRoles method, of class RoleDao.
     */
    @Test
    public void testGetAllRoles() {
        roledao.getAllRoles();
        List<Role> roleList = roledao.getAllRoles();
        assertEquals(roleList.size(), 3);
    }
    
    /**
     * Test of readRoleById method, of class RoleDao.
     */
    @Test
    public void testReadRoleById() {
        roledao.readRoleById(1);
        assertEquals("admin", "admin");
        roledao.readRoleById(2);
        assertEquals("write", "write");
        roledao.readRoleById(3);
        assertEquals("read", "read");

    }
 }


