/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.controller;

import com.sg.blogsite.model.Role;
import com.sg.blogsite.service.RoleServiceLayer;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class RoleController {

    private RoleServiceLayer service;

    @Inject
    public RoleController(RoleServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
    public String getAllRoles(Model model) {
        // Get all the roles
        List<Role> roleList = service.getAllRoles();

        // Put the List of blogs on the Model
        model.addAttribute("roleList", roleList);

        // Return the logical name of our View component
        return "role";
    }

    @RequestMapping(value = "/getRoleById", method = RequestMethod.GET)
    public String getRoleById(HttpServletRequest request) {
        String roleIdParameter = request.getParameter("roleId");
        int roleId = Integer.parseInt(roleIdParameter);
        service.readRoleById(roleId);
        return "redirect:displayContactsPage";
    }

}
