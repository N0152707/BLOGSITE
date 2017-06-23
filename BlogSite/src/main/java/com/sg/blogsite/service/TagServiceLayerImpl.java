/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.TagDao;
import com.sg.blogsite.model.Tag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class TagServiceLayerImpl implements TagServiceLayer {

    TagDao tagdao;

    public TagServiceLayerImpl(TagDao dao) {
        this.tagdao = dao;
    }

    @Override
    public Tag createTag(Tag tag) {
        tagdao.createTag(tag);
        return tag;
    }

    @Override
    public void updateTag(Tag tag) {
        tagdao.updateTag(tag);
    }

    @Override
    public Tag getTagById(int tagId) {
        return tagdao.getTagById(tagId);
    }

    @Override
    public List<Tag> getAllTagsInABlog(int tagId) {
        return tagdao.getAllTagsInABlog(tagId);
    }

}
