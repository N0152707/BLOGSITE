/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.model.Tag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface TagServiceLayer {

    public Tag createTag(Tag tag);

//    public void removeTag(int tagId);
    public void updateTag(Tag tag);

//    public List<Tag> getAllTags();
    public Tag getTagById(int tagId);

    public List<Tag> getAllTagsInABlog(int tagId);

}
