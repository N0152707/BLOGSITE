/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Tag;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class TagDaoTest {

    private TagDao tagdao;

    public TagDaoTest() {
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
        tagdao = ctx.getBean("tagDao", TagDao.class);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createTag method, of class TagDao.
     */
    @Test
    public void testCreateTag() {
        Tag newTag1 = new Tag();
        newTag1.setTagName("#TestingTags");
        tagdao.createTag(newTag1);
        Tag fromDb = tagdao.readTag(newTag1.getTagId());
        Assert.assertEquals(fromDb, newTag1);
        tagdao.deleteTag(newTag1.getTagId());
    }

    /**
     * Test of deleteTag method, of class TagDao.
     */
    @Test
    public void testDeleteTag() {
        Tag newTag2 = new Tag();
        newTag2.setTagName("#TagToDelete");
        tagdao.createTag(newTag2);
        Tag fromDb = tagdao.readTag(newTag2.getTagId());
        assertEquals(fromDb, newTag2);
        tagdao.deleteTag(newTag2.getTagId());
        assertNull(tagdao.readTag(newTag2.getTagId()));

    }

    /**
     * Test of readTag method, of class TagDao.
     */
    @Test
    public void testGetAllTags() {
        Tag newTag3 = new Tag();
        newTag3.setTagName("#TagFirstInList");
        tagdao.createTag(newTag3);
        Tag newTag4 = new Tag();
        newTag4.setTagName("#TagSecondInList");
        tagdao.createTag(newTag4);
        Tag newTag5 = new Tag();
        newTag5.setTagName("#TagThirdInList");
        tagdao.createTag(newTag5);
        List<Tag> tagList = tagdao.getAllTags();
        assertEquals(tagList.size(), 3);
        tagdao.deleteTag(newTag3.getTagId());
        tagdao.deleteTag(newTag4.getTagId());
        tagdao.deleteTag(newTag5.getTagId());
    }

    @Test
    public void testReadTag() {
        Tag newTag6 = new Tag();
        newTag6.setTagName("#AddTagForNumberSix");
        tagdao.createTag(newTag6);
        Tag newTag7 = new Tag();
        newTag7.setTagName("#AddTagForNumberSeven");
        tagdao.createTag(newTag7);
        Tag fromDb = tagdao.readTag(newTag6.getTagId());
        Assert.assertEquals(fromDb, newTag6);
        tagdao.deleteTag(newTag7.getTagId());
        tagdao.deleteTag(newTag6.getTagId());
    }

}
