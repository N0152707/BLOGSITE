/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.BlogHasTag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface BlogHasTagDao {

    public void createBlogHasTag(int blogId, int tagId);

    public void deleteBlogHasTag(int blogId, int tagId);

    public BlogHasTag readBlogHasTag(int blogId, int tagId);

    public List<BlogHasTag> getAllBlogHasTagsInABlog(int blogId, int tagId);

}
