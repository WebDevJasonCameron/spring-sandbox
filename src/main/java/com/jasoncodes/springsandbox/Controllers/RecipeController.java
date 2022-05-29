package com.jasoncodes.springsandbox.Controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jasoncodes.springsandbox.Models.Recipe;
import com.jasoncodes.springsandbox.Repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    // ATT
    private final RecipeRepository recipeDao;


    // CON
    public RecipeController(RecipeRepository recipeDao) {
        this.recipeDao = recipeDao;
    }

    // METH
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

    @PostMapping("/get-details")
    public String enterBasicRecipeInfoIntoDB(@RequestParam(name = "id") long cid,
                                             @RequestParam(name = "title") String title,
                                             @RequestParam(name = "image") String image){

        if(recipeDao.findRecipeByCid(cid) == null){
            System.out.println("Recipe Not found");
            recipeDao.save(new Recipe(cid, title, image));
        } else {
            return "redirect:/recipes/get-list";
        }

        return "/recipes/get-details";
    }

    // TEST
    @GetMapping("/test-json")
    public String showJsonTestFromDB(Model model){

         List<Recipe> recipes  = recipeDao.findAll();

//         for(Recipe recipe : recipes){
//             System.out.println("recipe.getTitle() = " + recipe.getTitle());
//         }


        String recipes2 = recipes.toString();

        model.addAttribute("recipes", recipes);
        model.addAttribute("recipes2", recipes2);

        System.out.println("recipes2 = " + recipes2);
        
        return "/recipes/test-json-from-db";
    }



}  //<--END
