package com.mibe.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"","/index","/index.html"})
    public String processGetIndex(Model aModel){
        return "index";
    }
}
