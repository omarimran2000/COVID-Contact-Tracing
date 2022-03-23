function authenticate() {
    $.ajax({
            url: "/checkUser",
            data: {
                username: $('#username').val(),
            },
            type: "GET"
        }
    ).then(function (data) {
        if (data == "true"){
            window.location = "/contactform";
        }
        else{
            $('#error').show();
        }
    });
}