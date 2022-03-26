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
function showQuarantine() {
    $.ajax({
            url: "/contactCaseQuarantine",
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

        generateTable();

        let cases = "";

        for (let i = 0; i < data.contactCases.length; i++) {
            cases += "<tr>";
            cases += "<td>" + data.contactCases[i].name;
            cases += "<td>" + data.contactCases[i].phone;
            cases += "<td>" + data.contactCases[i].email;
            cases += "<td>" + data.contactCases[i].id;
            cases += "<td>" + data.contactCases[i].covidID;
            cases += "<td>" + data.contactCases[i].exposureDate;
            cases += "</tr>";
        }
        $('#console').append("</table>");
        $('#console').append(cases);

    });

}

function printResponse(data) {
    $('#console').empty();
    $('#console').append("Cases : <br>");

    if(data.length > 0) {
        generateTable();
    }


    let cases = "";

    for (let i = 0; i < data.length; i++) {
        cases += "<tr>";
        cases += "<td>" + data[i].name + "</td>";
        cases += "<td>" + data[i].phone + "</td>";
        cases += "<td>" + data[i].email + "</td>";
        cases += "<td>" + data[i].id + "</td>";
        cases += "<td>" + data[i].covidID + "</td>";
        cases += "<td>" + data[i].exposureDate + "</td></tr>";
        cases += "</tr>";
    }
    $('#console').append("</table>");
    $('#console').append(cases);
}

function generateTable() {
    $('#console').append("<table><tr>");
    $('#console').append("<th>Name</th>");
    $('#console').append("<th>Phone</th>");
    $('#console').append("<th>Email</th>");
    $('#console').append("<th>ID</th>");
    $('#console').append("<th>COVID Case ID</th>");
    $('#console').append("<th>Exposure Date</th>");
}