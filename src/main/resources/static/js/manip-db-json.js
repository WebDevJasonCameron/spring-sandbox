
//     /html/body/div/span/text()[1]
//     //*[@id="json-input"]/text()[1]

let myJsonData =  $('#json-input').innerHTML;
myJsonData = JSON.stringify(myJsonData);

console.log('the myJsonData with jquery: ' + myJsonData);


let jsonInput = document.getElementById('json-input').innerText;
console.log('the jasonInput with v js: ' + jsonInput)


let jsonInputParsed = JSON.parse(jsonInput);
console.log(jsonInputParsed);





class Recipe {

    constructor(id,
                cid,
                title,
                imageUrl,
                summary,
                instructions,
                readyInMinutes,
                servings,
                sourceName,
                sourceUrl,
                vegetarian,
                vegan,
                glutenFree,
                dairyFree,
                dishType) {

        this.id = id;
        this.cid = cid;
        this.title = title;
        this.imageUrl = imageUrl;
        this.summary = summary;
        this.instructions = instructions;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.sourceName = sourceName;
        this.sourceUrl = sourceUrl;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
        this.dishType = dishType;
    }

}