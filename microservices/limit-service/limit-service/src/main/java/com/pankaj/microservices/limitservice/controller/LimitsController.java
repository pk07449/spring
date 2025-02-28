package com.pankaj.microservices.limitservice.controller;

import ch.qos.logback.core.model.Model;
import com.pankaj.microservices.limitservice.bean.Limits;
import com.pankaj.microservices.limitservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
@RefreshScope
public class LimitsController {
    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public Limits retriveLimits(){

        List<Limits> limitsList = Arrays.asList(new Limits(1,101));
        
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }



    @RequestMapping(value = "/user")
    public UserDetails user(Model model, Principal principal) {

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        UserDetails currentUser
                = (UserDetails) ((Authentication) principal).getPrincipal();

        return currentUser;
    }
}
