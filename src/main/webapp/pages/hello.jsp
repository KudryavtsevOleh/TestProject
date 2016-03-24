<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Todos</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <script src="/resources/js/Login.js"></script>
    <script src="/resources/js/Validation.js"></script>
    <script src="/resources/js/jquery-1.8.2.min.js"></script>
</head>
<body>
    <div class="username-info">
        <label>Username</label>
        <input class="username_js" type="text">
        <span class="has-error emptyField_js">Empty username</span>
        <span class="has-error invalidUsername_js">Invalid username</span>
    </div>
    <div class="password-info">
        <label>Password</label>
        <input class="password_js" type="text">
        <span class="has-error emptyPassword_js">Empty password</span>
        <span class="has-error invalidPassword_js">Invalid password</span>
    </div>
    <div class="submit-action">
        <input class="submit_js" type="button" value="Submit">
    </div>
    <script>
        Login.init();
    </script>
</body>
</html>