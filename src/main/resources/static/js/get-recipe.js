// VARS, ARRAYS AND LISTS
let rLR;
let rD;


// SEARCH BTN ACTION
$('#get-recipe-btn').on('click', (e) => {
    e.preventDefault();
    getSpoonRecipeListByKeyWord($('#search-input').val())
} )

// GET DETAIL'S PAGE
$('.add-btn').on('click', (e) => {
    e.preventDefault();
    const cid = $(this).val();
    console.log("cid: " + cid)
    // getSpoonRecipeDetailsByID(cid);
})

// GET R LIST
function getSpoonRecipeListByKeyWord(kw){
    const apiKey01 = SPOON_KEY_01;
    const apiKey02 = SPOON_KEY_02;
    const apiKey03 = SPOON_KEY_03;

    const spoonURL = 'https://api.spoonacular.com/recipes/complexSearch?apiKey=' + apiKey01 + '&query=' + kw + '&offset=0&number=100';
    const readOption = {
        method: 'GET',
    };

    fetch(spoonURL, readOption)
        .then((res) => res.json())
        .then((data) => {
            console.log(data);
            rLR = data;
        }).then(() => {
            $('#recipe-results').html(combineRows(rLR));
    })
}

// GET R DETAILS
function getSpoonRecipeDetailsByID(cid){
    const apiKey01 = SPOON_KEY_01;
    const apiKey02 = SPOON_KEY_02;
    const apiKey03 = SPOON_KEY_03;

    const spoonURL = 'https://api.spoonacular.com/recipes/' + cid + 'information?apiKey=' + apiKey01;
    const readOption = {
        method: 'GET',
    };

    fetch(spoonURL, readOption)
        .then((res) => res.json())
        .then((data) => {
            console.log(data);
            rD = data;
        })
        .then(() => {



        });
}




/**
 * Body
 */
// CREATE CARD
function makeRow(r){
    return `
        <div class="card border-0 mt-4">
            <div class="row no-gutters">
                <div class="col-sm-3">
                    <img src="${r.image}"" alt="#" class="card-img-top">
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
                        <form action="/recipes/get-list" method="get">
                            <input type="hidden" name="recipe-to-db" " >
                            <button type="submit" class="btn btn-primary add-btn" value="${r.id}>Add..
                            </button>  
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="recipe-details-${r.id}"></div>
    `
}

// COMBINE CARDS
function combineRows(rL){
    let output = '';
    for (let i = 0; i < rL.results.length; i++) {
        console.log("in the for loop")
        output += makeRow(rL.results[i])
    }
    console.log("output was : " + output);
    return output;
}

