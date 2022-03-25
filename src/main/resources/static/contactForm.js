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
            type: "GET"
        }
    ).then(function (data) {
        if (data) {
            $('#error').hide();
            $('#console').empty();
            $('#console').append(data.name + " has been added with ID: " + data.id);
        } else {
            $('#console').empty();
            $('#error').show();
        }
    });
}

function showMissingInfo() {
    $.ajax({
            url: "/contactCaseNotFilledOut",
            type: "GET"
        }
    ).then(function (data) {
        printResponse(data);
    });
}

function showHelp() {
    $.ajax({
            url: "/contactCaseHelp",
            type: "GET"
        }
    ).then(function (data) {
        printResponse(data);
    });
}

function showSymptoms() {
    $.ajax({
            url: "/contactCaseSymptoms",
            type: "GET"
        }
    ).then(function (data) {
        printResponse(data);
    });
}

function createCovidCase() {
    $.ajax({
            url: "/covidCaseAdd",
            type: "GET"
        }
    ).then(function (data) {
        $('#console').empty();
        $('#console').append("COVID Case Created with ID: " + data.id);

    });

}

function findCovidCase() {
    $.ajax({
            url: "/findCovidCase",
            type: "GET",
            data: {
                caseID: $('#searchID').val(),
            }
        }
    ).then(function (data) {
        $('#console').empty();
        $('#console').append("COVID Contact Cases with ID: " + data.id + "<br>");
        let cases = "";

        for (let i = 0; i < data.contactCases.length; i++) {
            cases += "Name: " + data.contactCases[i].name;
            cases += " Phone: " + data.contactCases[i].phone;
            cases += " Email: " + data.contactCases[i].email;
            cases += " ID: " + data.contactCases[i].id;
            cases += " COVID Case ID: " + data.contactCases[i].covidID;
            cases += " Exposure Date: " + data.contactCases[i].exposureDate;
            cases += "<br>";
        }
        $('#console').append(cases);

    });

}

function printResponse(data) {
    $('#console').empty();
    $('#console').append("Cases : <br>");
    let cases = "";

    for (let i = 0; i < data.length; i++) {
        cases += "Name: " + data[i].name;
        cases += " Phone: " + data[i].phone;
        cases += " Email: " + data[i].email;
        cases += " ID: " + data[i].id;
        cases += " COVID Case ID: " + data[i].covidID;
        cases += " Exposure Date: " + data[i].exposureDate;
        cases += "<br>";
    }
    $('#console').append(cases);
}