function filledOut() {
    $.ajax({
            url: "/contactCaseAddFilled",
            data: {
                name: $('#name').val(),
                id: $('#caseID').val(),
                symptoms: $('#symptoms').val(),
                help: $('#needSupport').val(),
                quarantine: $('#remain').val(),
                supportNeeded: $('#typeOfSupport').val()
            },
            type: "GET"
        }
    ).then(function () {
        $('#form').empty();
        $('#form').append("<p>Your form has been submitted. <a href=\"/\">Return to Menu</a></p>");
    });
}

function findContact() {
    $.ajax({
            url: "/findContactCase",
            data: {
                name: $('#name').val(),
                id: $('#caseID').val(),
            },
            type: "GET"
        }
    ).then(function (data) {
            if ((data) && (data.filledOut==false)){
                $('#error').hide();
                $('#nameCheck').hide();
                $('#form').show();
                $('#name').attr('readonly', 'readonly');
                $('#caseID').attr('readonly', 'readonly');
            } else {
                $('#error').show();
            }
        }
    );

}

