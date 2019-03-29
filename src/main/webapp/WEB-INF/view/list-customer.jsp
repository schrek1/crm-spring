<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Seznam zákazníků</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="window-header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>

    <div id="container">

        <input type="button" value="Přidat zákazníka" class="add-button"
               onclick="window.location.href='showFormForAdd'; return false"
        />

        <div id="content">
            <table>
                <tr>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Email</th>
                </tr>

                <c:forEach var="tempCustomer" items="${customers}">
                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>