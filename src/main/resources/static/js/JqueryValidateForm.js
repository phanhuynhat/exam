$().ready(function() {
    $("#form-log").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            username: {
                required: true,
                minlength: 6,
                maxlength: 20,
                validateUsername: true
            },
            password: {
                required:true,
                minlength: 6,
                maxlength: 30
            }
        },
        messages: {
            username: {
                required:"Please enter Username !",
                minlength: "Username must be at least 6 characters long !",
                maxlength: "Username is more than 20 characters long !",
            },
            password: {
                required:"Please enter password !",
                minlength: "Password must be at least 6 characters long !",
                maxlength: "Password is more than 30 characters long !"
            }
        }
    });

    $.validator.addMethod("validateUsername", function (value, element) {
        return this.optional(element) || !(/\`|\~|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\+|\=|\[|\{|\]|\}|\||\\|\'|\<|\,|\.|\>|\?|\/|\""|\;|\:|\s/.test(value));
    }, "Username not contain special characters !!!");
});

