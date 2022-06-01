package com.jasoncodes.springsandbox.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasoncodes.springsandbox.Models.Ingredient;
import com.jasoncodes.springsandbox.Models.Recipe;
import com.jasoncodes.springsandbox.Repositories.IngredientRepository;
import com.jasoncodes.springsandbox.Repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    // ATT
    private final RecipeRepository recipeDao;
    private final IngredientRepository ingredientDao;


    // CON
    public RecipeController(RecipeRepository recipeDao, IngredientRepository ingredientDao) {
        this.recipeDao = recipeDao;
        this.ingredientDao = ingredientDao;
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


    @PostMapping("/recipe-details-to-db")
    public String enterComplexRecipeDetailsIntoDb(@RequestParam(name = "cid") long cid,
                                        @RequestParam(name = "title") String title,
                                        @RequestParam(name = "image-url") String imageUrl,
                                        @RequestParam(name = "summary") String summary,
                                        @RequestParam(name = "instructions") String instructions,
                                        @RequestParam(name = "ready-in-minutes") String readyInMinutes,
                                        @RequestParam(name = "servings") String servings,
                                        @RequestParam(name = "source-name") String sourceName,
                                        @RequestParam(name = "source-url") String sourceUrl,
                                        @RequestParam(name = "vegetarian") boolean vegetarian,
                                        @RequestParam(name = "vegan") boolean vegan,
                                        @RequestParam(name = "gluten-free") boolean glutenFree,
                                        @RequestParam(name = "dairy-free") boolean dairyFree,
                                        @RequestParam(name = "dish-type") String dishType,

                                        @RequestParam(name = "ingredient-name") String ingredientName,
                                        @RequestParam(name = "ingredient-original") String ingredientOriginal
                                        ){

        Recipe recipe;
        List<Ingredient> ingredients = new ArrayList<>();


        if(recipeDao.findRecipeByCid(cid) != null){
            recipe = recipeDao.findRecipeByCid(cid);
        } else {
            recipe = new Recipe();
        }

        System.out.println("cid = " + cid);
        System.out.println("title = " + title);
        System.out.println("imageUrl = " + imageUrl);
        System.out.println("summary = " + summary);
        System.out.println("instructions = " + instructions);
        System.out.println("readyInMinutes = " + readyInMinutes);
        System.out.println("servings = " + servings);
        System.out.println("sourceName = " + sourceName);
        System.out.println("sourceUrl = " + sourceUrl);
        System.out.println("vegetarian = " + vegetarian);
        System.out.println("vegan = " + vegan);
        System.out.println("glutenFree = " + glutenFree);
        System.out.println("dairyFree = " + dairyFree);
        System.out.println("dishType = " + dishType);
        System.out.println("------");
        System.out.println("ingredientName = " + ingredientName);
        System.out.println("ingredientOriginal = " + ingredientOriginal);


        recipe.setCid(cid);
        recipe.setTitle(title);
        recipe.setImageUrl(imageUrl);
        recipe.setSummary(summary);
        recipe.setInstructions(instructions);
        recipe.setReadyInMinutes(readyInMinutes);
        recipe.setServings(servings);
        recipe.setSourceName(sourceName);
        recipe.setSourceUrl(sourceUrl);
        recipe.setVegetarian(vegetarian);
        recipe.setVegan(vegan);
        recipe.setGlutenFree(glutenFree);
        recipe.setDairyFree(dairyFree);
        recipe.setDishType(dishType);

        recipeDao.save(recipe);

        String[] iNames = ingredientName.split(",");
        String[] iAmount = ingredientOriginal.split(",");

        for (int i = 0; i < iNames.length; i++) {
            Ingredient ingredient = new Ingredient(iNames[i], iAmount[i], recipe);
            ingredientDao.save(ingredient);
            ingredients.add(ingredient);
        }


        return "redirect:/recipes/recipe-details-to-db";
    }

    @GetMapping("/recipe-details-to-db")
    public String showRecipeDetailsToDb(){

        return "/recipes/recipe-details-to-db";
    }



    // TEST
    @GetMapping("/test-json")
    public String showJsonTestFromDB(Model model){

        List<Recipe> recipes  = recipeDao.findAll();
        List<Ingredient> ingredients = ingredientDao.findAll();


        String json = "";
        String iJson = "";


        //<--KEY to JSON formatting!
        ObjectMapper objectMapper = new ObjectMapper();

        // Set Recipe data into json
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipes);
        } catch (Exception e){
            e.printStackTrace();
        }

        // Set Ingredient data into json
        try {
            iJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ingredients);
        } catch (Exception e){
            e.printStackTrace();
        }


        model.addAttribute("json", json);
        model.addAttribute("iJson", iJson);
        model.addAttribute("recipes", recipes);


        return "recipes/test-json-from-db";
    }


    // TEST JS CARDS
    @GetMapping("/test-j-r-cards")
    public String ShowTestJRCards(Model model){
        List<Recipe> recipes  = recipeDao.findAll();
        String json = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipes);
        } catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("json", json);


        return "/recipes/test-js-r-card";
    }


}  //<--END
