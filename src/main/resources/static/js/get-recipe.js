// VARS, ARRAYS AND LISTS
let recipeListReturn;


// GET RN
$('#get-recipe-btn').on('click', (e) => {
    e.preventDefault();
    readSpoonRecipeListByKeyWord($('#search-input').val())
} )


// READ
function readSpoonRecipeListByKeyWord(kw){
    const apiKey01 = SPOON_KEY_01;
    const apiKey02 = SPOON_KEY_02;
    const apiKey03 = SPOON_KEY_03;

    const spoonURL = 'https://api.spoonacular.com/recipes/complexSearch?apiKey=' + apiKey01 + '&query=' + kw;
    const readOption = {
        method: 'GET',
    };

    fetch(spoonURL, readOption)
        .then((res) => res.json())
        .then((data) => {
            console.log(data);
            recipeListReturn = data;
            // recipeListReturn = JSON.stringify(data);
            // console.log('recipeListReturn 1: ' +  recipeListReturn);
        }).then(() => {
            // console.log('recipeListReturn 2: ' + recipeListReturn);
            cycleDataArray(recipeListReturn);
    })

}

// TEST
function cycleDataArray(dArray){
    for (let i = 1; i < dArray.length; i++) {
        console.log(dArray.results[i] + ' | ' + dArray.results[i].title + ' | ' + dArray.results[i].image);

    }
}



// CREATE ROW
function makeRow(){

}