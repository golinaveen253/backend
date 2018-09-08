package com.nouhoun.springboot.jwt.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.bean.RoleBean;
import com.nouhoun.springboot.jwt.integration.bean.UserBean;
import com.nouhoun.springboot.jwt.integration.domain.RandomCity;
import com.nouhoun.springboot.jwt.integration.service.GenericService;

/**
 * Created by nydiarra on 06/05/17.
 */
@RestController
@RequestMapping("/springjwt")
public class ResourceController {
    @Autowired
    private GenericService service;

    @RequestMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<RandomCity> getUser(){
        return service.findAllRandomCities();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<UserBean> getUsers(@RequestHeader String username, @RequestHeader String pswd){
    	System.out.println("usernam-->" + username);
    	System.out.println("getUsersEntered");
        return service.getAllUsers();
    }
    
    @RequestMapping(value ="/roles", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<RoleBean> getRoles(@RequestHeader String username, @RequestHeader String pswd){
    	System.out.println("getRoles Entered-->" + username);
    	System.out.println("getUsersEntered");
        return service.getAllRoles();
    }
    
    @RequestMapping(value ="/user/{userName}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<UserBean> getUserByUserId(@PathVariable("userName") String userName){
    	System.out.println("UserName----->" + userName);
    	System.out.println("UserName----->" + service.getUserByUserName(userName));
        return service.getUserByUserName(userName);
    }
    
}
