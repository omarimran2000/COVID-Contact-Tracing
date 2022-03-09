function filledOut() {
    $.ajax({
            url: "/contactCaseAddFilled",
            data: {
                name: $('#name').val(),
                id: $('#caseID').val(),
                symptoms: $('#symptoms').val(),
                help: $('#needSupport').val()
            },
            type:"GET"
        }
    ).then(function ()
    {
        $('#form').empty();
        $('#form').append("<p>Your form has been submitted. <a href=\"/\">Return to Menu</a></p>");
    });
}
