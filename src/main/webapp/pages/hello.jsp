<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Todos</title>
    <%@include file="headers.jsp"%>
    <link rel="stylesheet" type="text/css" href="/resources/css/home.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/todo.css">
    <script src="/resources/js/Login.js"></script>
    <script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form">
                        <fieldset>
                            <div class="alert-danger invalidUsername_js" style="display: none;"></div>
                            <div class="form-group">
                                <input class="form-control username_js" placeholder="Username" name="email" type="text"><br>
                            </div>
                            <div class="alert-danger invalidPassword_js" style="display: none;"></div>
                            <div class="form-group">
                                <input class="form-control password_js" placeholder="Password" name="password" type="password" value=""><br>
                            </div>
                            <input class="btn btn-lg btn-success btn-block submit_js" type="button" value="Login">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="errorDialog_js" style="display: none;">Internal server error.</div>
<script>
    $(document).ready(function(){
        $(document).mousemove(function(e){
            TweenLite.to($('body'),
                    .5,
                    { css:
                    {
                        backgroundPosition: ""+ parseInt(event.pageX/8) + "px "+parseInt(event.pageY/'12')+"px, "+parseInt(event.pageX/'15')+"px "+parseInt(event.pageY/'15')+"px, "+parseInt(event.pageX/'30')+"px "+parseInt(event.pageY/'30')+"px"
                    }
                    });
        });
    });
    Login.init();
</script>
</body>
</html>