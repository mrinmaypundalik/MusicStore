package com.musicstore.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHome {
    
    @RequestMapping
    public String adminPage(){
	return "admin";
    }
    
    @RequestMapping("/customer")
    public String customerManagement(Model model){
	return "customerManagement";
    }
}
