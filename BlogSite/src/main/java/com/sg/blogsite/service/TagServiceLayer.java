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

    public Tag createTag(Tag tag, int blogId);

    public void deleteTag(int tagId);

    public Tag readTag(int tagId);

    public List<Tag> getAllTags();

    public List<Tag> getAllTagsInABlog(int blogId);

}
