/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Tag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface TagDao {

    public Tag createTag(Tag tag);

//    public void removeTag(int tagId);
    public void updateTag(Tag tag);

//
    public Tag readTag(int tagId);

    public List<Tag> getAllTags();

    public List<Tag> getAllTagsInABlog(int blogId);

}
