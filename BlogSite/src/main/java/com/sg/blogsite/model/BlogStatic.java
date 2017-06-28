/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.model;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class BlogStatic {

    Integer blogStaticId;
    String blogStaticTitle;
    String blogStaticArticle;

    public Integer getBlogStaticId() {
        return blogStaticId;
    }

    public void setBlogStaticId(Integer blogStaticId) {
        this.blogStaticId = blogStaticId;
    }

    public String getBlogStaticTitle() {
        return blogStaticTitle;
    }

    public void setBlogStaticTitle(String blogStaticTitle) {
        this.blogStaticTitle = blogStaticTitle;
    }

    public String getBlogStaticArticle() {
        return blogStaticArticle;
    }

    public void setBlogStaticArticle(String blogStaticArticle) {
        this.blogStaticArticle = blogStaticArticle;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.blogStaticId);
        hash = 53 * hash + Objects.hashCode(this.blogStaticTitle);
        hash = 53 * hash + Objects.hashCode(this.blogStaticArticle);
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
        final BlogStatic other = (BlogStatic) obj;
        if (!Objects.equals(this.blogStaticTitle, other.blogStaticTitle)) {
            return false;
        }
        if (!Objects.equals(this.blogStaticArticle, other.blogStaticArticle)) {
            return false;
        }
        if (!Objects.equals(this.blogStaticId, other.blogStaticId)) {
            return false;
        }
        return true;
    }


    


}
