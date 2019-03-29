<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Uložení zákazníka</title>

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
    <div id="container">
        <h3>Uložit zákazníka</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            <table>
                <tbody>
                <tr>
                    <td><label>Jméno:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Příjmení:</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Uložit" class="save"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear; both;"></div>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Zpět na seznam</a>
        </p>

    </div>
</div>

</body>
</html>