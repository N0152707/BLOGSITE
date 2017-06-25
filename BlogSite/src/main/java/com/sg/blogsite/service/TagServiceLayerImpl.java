/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.BlogHasTagDao;
import com.sg.blogsite.dao.TagDao;
import com.sg.blogsite.model.Tag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class TagServiceLayerImpl implements TagServiceLayer {

    TagDao tagdao;
    BlogHasTagDao bhtdao;

    public TagServiceLayerImpl(TagDao dao) {
        this.tagdao = dao;
    }

    @Override
    public Tag createTag(Tag tag, int blogId) {
        tagdao.createTag(tag);
        int blogBlogId = blogId;
        int tagTagId = tag.getTagId();
        bhtdao.createBlogHasTag(blogId, tagTagId);
        return tag;
    }

    @Override
    public void deleteTag(int tagId) {
        tagdao.deleteTag(tagId);
    }

    @Override
    public Tag readTag(int tagId) {
        return tagdao.readTag(tagId);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagdao.getAllTags();
    }

    @Override
    public List<Tag> getAllTagsInABlog(int tagId) {
        return tagdao.getAllTagsInABlog(tagId);
    }

}
