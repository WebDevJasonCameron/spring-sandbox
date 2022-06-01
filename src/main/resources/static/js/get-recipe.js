// VARS, ARRAYS AND LISTS
let rLR;
let rD;

/**
 *   PAGE ACTIONS
 */
// SEARCH BTN ACTION
$('#get-recipe-btn').on('click', (e) => {
    e.preventDefault();
    getSpoonRecipeListByKeyWord($('#search-input').val())
})

// TEST
function testFunction(id){
    getSpoonRecipeDetailsByID(id)
}


/**
 *    API CRUD
 */
// GET R LIST
function getSpoonRecipeListByKeyWord(kw){
    // const apiKey = SPOON_KEY_01;
    // const apiKey = SPOON_KEY_02;
    const apiKey = SPOON_KEY_03;

    const spoonURL = 'https://api.spoonacular.com/recipes/complexSearch?apiKey=' + apiKey + '&query=' + kw + '&offset=0&number=10';
    const readOption = {
        method: 'GET',
    };

    fetch(spoonURL, readOption)
        .then((res) => res.json())
        .then((data) => {
            // console.log(data);
            rLR = data;
        }).then(() => {
            $('#recipe-results').html(combineCards(rLR));
    })
}

// GET R DETAILS
function getSpoonRecipeDetailsByID(cid){
    // const apiKey = SPOON_KEY_01;
    // const apiKey = SPOON_KEY_02;
    const apiKey = SPOON_KEY_03;

    const spoonURL = 'https://api.spoonacular.com/recipes/' + cid + '/information?apiKey=' + apiKey;
    const readOption = {
        method: 'GET',
    };``

    fetch(spoonURL, readOption)
        .then((res) => res.json())
        .then((data) => {
            console.log(data);
            rD = data;
        })
        .then(() => {
            // Loader here
            $('#recipe-details-modal-content').html(makeModalBody(rD));
        });
}




/**
 * BUILD BODY
 */
// CREATE CARD
function makeCard(r){
    return  `
        <div class="card border-0 mt-4">
            <div class="row no-gutters">
                <div class="col-sm-3">
                    <img src="${r.image}" alt="#" class="card-img-top">
                </div>
                <div class="col-sm-9">
                    <div class="card-body">
                        <div class="card-title">
                            ${r.title}
                        </div>
                        <div class="h4">
                             ${r.id}
                        </div>
                    </div>
                    <div class="card-footer">
                        <form action="/recipes/get-details" method="post" >       <!--Can remove for modal-->
                            <input type="hidden" name="image" value="${r.image}" >
                            <input type="hidden" name="title" value="${r.title}" >
                            <input type="hidden" name="id" value="${r.id}" >
                            <button type="submit" class="btn btn-primary add-btn">
                                Add to DB
                            </button>  
                        </form>           
                    </div>
                    <div>
                        <button 
                            onclick="testFunction(${r.id})"
                            class="btn btn-primary" 
                            type="button" 
                            data-toggle="modal" 
                            data-target="#recipe-details-modal"
                            >
                                Access Modal
                        </button>
                    </div>
                </div>
            </div>
        </div>
    `
}

// COMBINE CARDS
function combineCards(rL){
    let output = '';
    for (let i = 0; i < rL.results.length; i++) {
        output += makeCard(rL.results[i]);
    }
    return output;
}

// CREATE MODAL BODY
function makeModalBody(r){
    return `
                        <div  id="recipe-details-modal-content" >
                    <!--header-->
                    <div class="modal-header">
                        <img src="${r.image}" alt="Image data here">
                    </div>
                    <!--body-->
                    <div class="modal-body">
                        <h4>${r.title}</h4>
                        <ul>
                            <li>${r.summary}</li>
                            <li>${r.instructions}</li>
                            <li>Time: ${r.readyInMinutes}</li> 
                        </ul>
                        <h4>Ingredients</h4>
                        <ol> 
                        
                        
                                ` +  ingredientList(r) + `                   
                        
                        
                        </ol>
                        <h4>Diet Notes:</h4>
                        <ul>
                            <li>vegetarian: ${r.vegetarian}</li>
                            <li>vegan: ${r.vegan}</li>
                            <li>gluten free: ${r.glutenFree}</li>
                            <li>dairy free: ${r.dairyFree}</li>
                            <li>dish type: ${r.dishTypes}</li>
                        </ul>

                    </div>
                    <!--footer-->
                    <div class="modal-footer">
                        <div>
                            <small>Source:
                                <a href="${r.sourceUrl}" alt="source link">${r.sourceName}</a>
                            </small>
                        </div>
                        <form action="/recipes/recipe-details-to-db" method="post">
                            <div id="recipe-data">
                                <input type="hidden" name="cid" value="${r.id}">
                                <input type="hidden" name="title" value="${r.title}">
                                <input type="hidden" name="image-url" value="${r.image}">
                                <input type="hidden" name="summary" value="${r.summary.replaceAll('"', '')}">
                                <input type="hidden" name="instructions" value="${r.instructions.replaceAll('"', '')}">
                                <input type="hidden" name="ready-in-minutes" value="${r.readyInMinutes}">
                                <input type="hidden" name="servings" value="${r.servings}">
                                <input type="hidden" name="source-name" value="${r.sourceName.replaceAll('"', '')}">
                                <input type="hidden" name="source-url" value="${r.sourceUrl.replaceAll('"', '')}">
                                <input type="hidden" name="vegetarian" value="${r.vegetarian}">
                                <input type="hidden" name="vegan" value="${r.vegan}">
                                <input type="hidden" name="gluten-free" value="${r.glutenFree}">
                                <input type="hidden" name="dairy-free" value="${r.dairyFree}">
                                <input type="hidden" name="dish-type" value="${r.dishTypes}">

                                
                            </div>
                            <div id="ingredients">      <!--for each-->
    
    
                            ` + hiddenIngredientInputList(r) + `
    
    
                            </div>
                            <div>
                                <button 
                                    class="btn btn-secondary" 
                                    type="button" 
                                    data-dismiss="modal">
                                        Close
                                </button>                                
                                <button 
                                    class="btn btn-primary" 
                                    type="submit">
                                        Add to DB
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
    `
}

// CREATE INGREDIENT LIST ITEM
function ingredientListItem(rI){
    return `
        <li>${rI.name}, Amount: ${rI.original}</li>
    `
}

// COMBINE INGREDIENTS INTO A LIST
function ingredientList(r){
    let output = '';
    for (let i = 0; i < r.extendedIngredients.length; i++) {
        output += ingredientListItem(r.extendedIngredients[i]);
    }
    return output;
}

// CREATE HIDDEN INGREDIENT INPUT FOR FORM
function hiddenIngredientInputs(rI){
    return `
                <input type="hidden" name="ingredient-name" value="${rI.name}">
                <input type="hidden" name="ingredient-original" value="${rI.original}">
    `
}

// COMBINE HIDDEN INGREDIENT LIST FOR FORM
function hiddenIngredientInputList(r){
    let output = '';
    for (let i = 0; i < r.extendedIngredients.length; i++) {
        output += hiddenIngredientInputs(r.extendedIngredients[i]);
    }
    return output;
}
