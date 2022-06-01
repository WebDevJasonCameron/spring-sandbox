let jsonInput = document.getElementById('json-input').innerText;
let jIP = JSON.parse(jsonInput);




function makeCard(r){
    return  `
        <div class="card border-0 mt-4">
            <div class="row no-gutters">
                <div class="col-sm-3">
                    <img src="${r.imageUrl}" alt="#" class="card-img-top">
                </div>
                <div class="col-sm-9">
                    <div class="card-body">
                        <div class="card-title">
                            ${r.title}
                        </div>
                        <div class="h4">
                             ${r.summary}
                        </div>
                    </div>
                    <div class="card-footer">         
                    </div>
                </div>
            </div>
        </div>
    `
}

function combineCards(rL){
    let output = '';
    for (let i = 0; i < rL.length; i++) {
        output += makeCard(rL[i]);
    }
    return output;
}

$('#r-cards').html(combineCards(jIP))
