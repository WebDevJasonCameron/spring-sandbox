// VARS, ARRAYS AND LISTS
let rLR;


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
            console.log(data.results[0].id)
            rLR = data;
            console.log(rLR.results[0].id);
        // }).then(() => {
            console.log(rLR.results[0].id);
            // cycleDataArray(recipeListReturn);
    })

}

// TEST
function cycleDataArray(dArray){
    for (let i = 0; i < dArray.length; i++) {
        console.log(dArray.results[i] + ' | ' + dArray.results[i].title + ' | ' + dArray.results[i].image);

    }
}


// CREATE ROW
function makeRow(r, n){
    return `<tr>
                <th scope="row">${r.results[n].image}</th>
                <th>${r.results[n].id}</th>
                <th>${r.results[n].title}</th>
                <th>
                    <form action="">
                        <input type="hidden" name="recipe-${r.results[n].id}" value="${r.results[n].id}">
                        <button type="submit" class="btn btn-primary">Add...</button></th>
                    </form>
            </tr>`


}