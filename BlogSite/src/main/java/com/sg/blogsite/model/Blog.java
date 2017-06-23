/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Blog {
    
    Integer blogId;
    Boolean blogPublished;
    LocalDate blogDatePublished;
    String blogTitle;
    String blogArtical;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Boolean getBlogPublished() {
        return blogPublished;
    }

    public void setBlogPublished(Boolean blogPublished) {
        this.blogPublished = blogPublished;
    }

    public LocalDate getBlogDatePublished() {
        return blogDatePublished;
    }

    public void setBlogDatePublished(LocalDate blogDatePublished) {
        this.blogDatePublished = blogDatePublished;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogArtical() {
        return blogArtical;
    }

    public void setBlogArtical(String blogArtical) {
        this.blogArtical = blogArtical;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.blogId);
        hash = 53 * hash + Objects.hashCode(this.blogPublished);
        hash = 53 * hash + Objects.hashCode(this.blogDatePublished);
        hash = 53 * hash + Objects.hashCode(this.blogTitle);
        hash = 53 * hash + Objects.hashCode(this.blogArtical);
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
        final Blog other = (Blog) obj;
        if (!Objects.equals(this.blogTitle, other.blogTitle)) {
            return false;
        }
        if (!Objects.equals(this.blogArtical, other.blogArtical)) {
            return false;
        }
        if (!Objects.equals(this.blogId, other.blogId)) {
            return false;
        }
        if (!Objects.equals(this.blogPublished, other.blogPublished)) {
            return false;
        }
        if (!Objects.equals(this.blogDatePublished, other.blogDatePublished)) {
            return false;
        }
        return true;
    }
    
    
    
}
