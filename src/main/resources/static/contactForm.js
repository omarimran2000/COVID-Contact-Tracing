function addCase() {
    $.ajax({
            url: "/contactCaseAdd",
            data: {
                name: $('#name').val(),
                covidID: $('#caseID').val(),
                exposureDate: $('#expDate').val(),
                phone: $('#pNumber').val(),
                email: $('#email').val()
            },
            type:"GET"
        }
    ).then(function (data) {
        $('#console').empty();
        $('#console').append(data.name + " has been added with ID: "+ data.id);
    });
}
function showMissingInfo() {
    $.ajax({
            url: "/contactCaseNotFilledOut",
            type:"GET"
        }
    ).then(function(data)
    {
        printResponse(data);
    });
}
function showHelp() {
    $.ajax({
            url: "/contactCaseHelp",
            type:"GET"
        }
    ).then(function(data)
    {
        printResponse(data);
    });
}
function showSymptoms() {
    $.ajax({
            url: "/contactCaseSymptoms",
            type:"GET"
        }
    ).then(function(data)
    {
        printResponse(data);
    });
}
function printResponse(data) {
    $('#console').empty();
    $('#console').append("Cases : <br>");
    let cases = "";

    for (let i=0;i<data.length;i++)
    {
        cases +=  "Name: " + data[i].name;
        cases +=  " Phone: " + data[i].phone;
        cases +=  " Email: " + data[i].email;
        cases +=  " ID: " + data[i].id;
        cases +=  " COVID Case ID: " + data[i].covidID;
        cases +=  " Exposure Date: " + data[i].exposureDate;
        cases += "<br>";
    }
    $('#console').append(cases);
}