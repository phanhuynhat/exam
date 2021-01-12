var username = document.forms['form']['username'];
var password = document.forms['form']['password'];

var username_error = document.getElementById('username_error');
var username_error_length = document.getElementById('username_error_length');
var username_error_characters = document.getElementById('username_error_characters');
var regexText = /\`|\~|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\+|\=|\[|\{|\]|\}|\||\\|\'|\<|\,|\.|\>|\?|\/|\""|\;|\:|\s/;

var password_error = document.getElementById('password_error');
var password_error_length = document.getElementById('password_error_length');

function submitForm() {
    if (username.value == "") {
        username.style.border = "1px solid red";
        username_error.style.display = "block";
        username.focus();
        return false;
    } else {
        username_error.style.display = "none";
        if (username.value.length < 9 || username.value.length > 20) {
            username.style.border = "1px solid red";
            username_error_length.style.display = "block";
            username.focus();
            return false;
        } else {
            username_error_length.style.display = "none";
            if (regexText.test(username.value)) {
                username.style.border = "1px solid red";
                username_error_characters.style.display = "block";
                username.focus();
                return false;
            } else {
                username_error_characters.style.display = "none";
            }
        }
    }

    if (password.value == "") {
        password.style.border = "1px solid red";
        password_error.style.display = "block";
        password.focus();
        return false;
    } else {
        password_error.style.display = "none";
        if (password.value.length < 6 || password.value.length > 20) {
            password.style.border = "1px solid red";
            password_error_length.style.display = "block";
            password.focus();
            return false;
        } else {
            password_error_length.style.display = "none";
        }
    }
}




