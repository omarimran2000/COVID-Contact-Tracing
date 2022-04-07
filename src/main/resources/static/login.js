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
    var specialCharacters = /[!@#$%^&*()_=+<>?]/;
    var uppercase = /[A-Z]/;
    var lowercase = /[a-z]/;
    var goodPass = true;
    $('#errorRegister').hide();
    $('#errorLength').hide();
    $('#passHasSpace').hide();
    $('#passNoCap').hide();
    $('#passNoLower').hide();
    $('#passNoSpecial').hide();

    const user = $('#username').val();
    const pass1 = $('#password').val();
    const pass2 = $('#password2').val();

    if (pass1 != pass2)
    {
        goodPass = false;
        $('#errorRegister').show();
    }
    if (pass1.trim().length < 8)
    {
        goodPass = false;
        $('#errorLength').show();
    }
    if(pass1.indexOf(' ') >= 0)
    {
        goodPass = false;
        $('#passHasSpace').show();
    }
     if(!specialCharacters.test(pass1))
        {
            goodPass = false;
            $('#passNoSpecial').show();
        }
    if(!uppercase.test(pass1))
    {
        goodPass = false;
        $('#passNoCap').show();
    }
     if(!lowercase.test(pass1))
     {
        goodPass = false;
        $('#passNoLower').show();
     }

    if(goodPass)
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
function showPassword(){
    var pswd = $('#password')[0]
    if (pswd.type == "password") {
        pswd.type = "text";
        $('#password2')[0].type = "text"; // For register.html

    } else {
        pswd.type = "password";
        $('#password2')[0].type = "password";
    }
}