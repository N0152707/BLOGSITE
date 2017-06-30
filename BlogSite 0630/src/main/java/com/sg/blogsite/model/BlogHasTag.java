/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.model;

/**
 *
 * @author apprentice
 */
public class BlogHasTag {

    int blogBlogId;
    int tagTagId;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.blogBlogId;
        hash = 79 * hash + this.tagTagId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BlogHasTag other = (BlogHasTag) obj;
        if (this.blogBlogId != other.blogBlogId) {
            return false;
        }
        if (this.tagTagId != other.tagTagId) {
            return false;
        }
        return true;
    }

    public int getBlogBlogId() {
        return blogBlogId;
    }

    public void setBlogBlogId(int blogBlogId) {
        this.blogBlogId = blogBlogId;
    }

    public int getTagTagId() {
        return tagTagId;
    }

    public void setTagTagId(int tagTagId) {
        this.tagTagId = tagTagId;
    }

}
