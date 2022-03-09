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
    );
}
