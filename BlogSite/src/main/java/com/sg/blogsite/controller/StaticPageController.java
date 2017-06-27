/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.controller;

import com.sg.blogsite.service.BlogServiceLayer;
import javax.inject.Inject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
public class StaticPageController {

    private BlogServiceLayer service;

    @Inject
    public StaticPageController(BlogServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = {"/aboutUs", "/"}, method = RequestMethod.GET)
    public String displayStaticPage(Model model) {
//        List<StaticPage> staticPageList = service.getLastFiveBlogs();
//        model.addAttribute("staticPageList", staticPageList);
        return "staticPage";
    }

}
