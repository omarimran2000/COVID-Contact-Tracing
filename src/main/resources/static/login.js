function authenticate() {
    $.ajax({
            url: "/checkUser",
            data: {
                username: $('#username').val(),
                password: $('#password').val(),
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
function registerUser(){
    if ($('#password').val() != $('#password2').val())
    {

        $('#errorRegister').show();
    }
    else
    {
        $.ajax({
                url: "/registerUser",
                data: {
                    username: $('#username').val(),
                    password: $('#password').val(),
                },
                type: "GET"
            }
        ).then(function (data) {
                window.location = "/login";
            });
    }
}