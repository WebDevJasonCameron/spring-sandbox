/**
 * RECIPE STUFF
 */
// V JS works by grabbing the hidden div tag with json th:text span inside
let jsonInput = document.getElementById('json-input').innerText;
// console.log('the jasonInput with v js: ' + jsonInput)

// JSON parse
let jIP = JSON.parse(jsonInput);
// console.log(jIP);
// console.log(jIP[9]);
// console.log(jIP[9].title);

const count = Object.keys(jIP).length;
// console.log(count);

let rCount = 0;

// JS Searching through the JSON list
// for (let i = 0; i < jIP.length; i++) {
//     if(jIP[i].dishType.indexOf("lunch") > -1){
//         rCount += 1;
//         console.log(rCount+'. ' + jIP[i].dishType);
//         console.log(rCount+'. ' + jIP[i].title);
//     }
// }


/**
 * INGREDIENT STUFF
 */
let iJsonInput = document.getElementById('iJson-input').innerText;
let iJIP = JSON.parse(iJsonInput);

const iCount = Object.keys(iJIP).length;
console.log('count for ingredients is: ' + iCount)
console.log(iJIP);




// Helper function
function getIng(rip){
    for (let i = 0; i < iJIP.length; i++) {
        }
}

