package com.jasoncodes.springsandbox.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @GetMapping
    public String showRecipeHomePage(){
        return "/recipes/index";
    }

    @GetMapping("/get-list")
    public String getRecipeListPage(){
        return "/recipes/get-list";
    }

    @GetMapping("/get-details")
    public String getRecipeDetailsPage(){
        return "/recipes/get-details";
    }

}  //<--END
