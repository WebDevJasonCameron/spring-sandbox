The following code was attempted in the js file to build a hidden form for parsed out recipe details

```javascript

                            <div id="recipe-data">
                                <input type="hidden" name="cid" value="${r.id}">
                                <input type="hidden" name="title" value="${r.title}">
                                <input type="hidden" name="image-url" value="${r.image}">
                                <input type="hidden" name="summary" value="${r.summary}">
                                <input type="hidden" name="instructions" value="${r.instructions}">
                                <input type="hidden" name="ready-in-minutes" value="${r.readyInMinutes}">
                                <input type="hidden" name="servings" value="${r.servings}">
                                <input type="hidden" name="source-name" value="${r.sourceName}">
                                <input type="hidden" name="source-url" value="${r.sourceUrl}">
                                <input type="hidden" name="vegetarian" value="${r.vegetarian}">
                                <input type="hidden" name="vegan" value="${r.vegan}">
                                <input type="hidden" name="gluten-free" value="${r.glutenFree}">
                                <input type="hidden" name="dairy-free" value="${r.dairyFree}">
                                <input type="hidden" name="weight-watchers-smart-points" value="${r.weightWatcherSmartPoints}">
                                <input type="xhidden" name="dish-type" value="${r.dishTypes}">

                                
                            </div>
                            <div id="ingredients">      <!--for each-->
    
    
                            ` + hiddenIngredientInputList(r) + `
    
    
                            </div>


```

The following code was placed in the recipe controller to accept the hidden form from the modal

```java

// From enterComplexRecipeDetailsIntoDb
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
@RequestParam(name = "weight-watchers-smart-points") long weightWatchersSmartPoints,
@RequestParam(name = "dish-type") String dishType,

@RequestParam(name = "ingredient-name") String ingredientName,
@RequestParam(name = "ingredient-original") String ingredientOriginal

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
        System.out.println("weightWatchersSmartPoints = " + weightWatchersSmartPoints);
        System.out.println("dishType = " + dishType);
        System.out.println("------");
        System.out.println("ingredientName = " + ingredientName);
        System.out.println("ingredientOriginal = " + ingredientOriginal);



//        recipe.setCid(cid);
//        recipe.setTitle(title);
//        recipe.setImageUrl(imageUrl);
//        recipe.setSummary(summary);
//        recipe.setInstructions(instructions);
//        recipe.setReadyInMinutes(readyInMinutes);
//        recipe.setServings(servings);
//        recipe.setSourceName(sourceName);
//        recipe.setSourceUrl(sourceUrl);
//        recipe.setVegetarian(vegetarian);
//        recipe.setVegan(vegan);
//        recipe.setGlutenFree(glutenFree);
//        recipe.setDairyFree(dairyFree);
//        recipe.setWeightWatchersSmartPoints(weightWatchersSmartPoints);
//        recipe.setDishType(dishType);




```