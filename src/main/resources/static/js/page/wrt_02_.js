function HighSchoolStartCal() {
    if(document.getElementById("highschoolS").value.length==4){
            document.getElementById("highschoolS").value += '.';
        }
}

function HighSchoolEndCal() {
    if(document.getElementById("highschoolE").value.length==4){
            document.getElementById("highschoolE").value += '.';
        }
}
function changeTypeText(){
    $('#highschoolS').replaceWith("<div>"+$('#highschoolS').val()+"</div>");
    $('#highschoolE').replaceWith("<div>"+$('#highschoolE').val()+"</div>");
}