<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Přihlášení uživatele</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div>
    <div id="loginbox" style="margin-top: 50px;"
         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

        <div class="panel panel-info">

            <div class="panel-heading">
                <div class="panel-title">Přihlášení</div>
            </div>

            <div style="padding-top: 30px" class="panel-body">

                <form:form action="${pageContext.request.contextPath}/processLogin" method="POST">

                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>
                                <c:if test="${param.expired != null}">
                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        Doba přihlášení vypršela, musíte se znovu přihlásit.
                                    </div>
                                </c:if>

                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        Nesprávné údaje pro přihlášení.
                                    </div>
                                </c:if>

                                <c:if test="${param.logout != null}">
                                    <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                        Byli jste odhlášeni ze systému.
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="username" placeholder="uživatelské jméno" class="form-control">
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" name="password" placeholder="heslo" class="form-control">
                    </div>

                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btn btn-success">Přihlášení</button>
                        </div>
                    </div>

                </form:form>

            </div>
        </div>
    </div>
</div>

</body>
</html>

