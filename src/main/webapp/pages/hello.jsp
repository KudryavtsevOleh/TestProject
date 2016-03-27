<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Todos</title>
    <%@include file="headers.jsp"%>
    <script>
        Autologin.autologin();
    </script>
</head>
<body>

    <div class="container loginContainer_js">
        <%@include file="loginContainer.jsp"%>
    </div>

    <script>
        $(document).ready(function(){
            $(document).mousemove(function(e) {
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
    <div class="errorDialog_js" style="display: none;"></div>
    <div class="todosContainer_js" style="display: none;"></div>
</body>
</html>