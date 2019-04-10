<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="searchText" type="java.lang.String"--%>
<%--@elvariable id="customers" type="java.util.List<cz.schrek.spring.mvc.crm.entity.Customer>"--%>


<c:url var="searchLink" value="/customer/search"/>
<c:url var="customerListLink" value="/customer/list"/>

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
            <form:form action="${searchLink}" method="GET">
                <tr>
                    <td><label>Hledat zákazníka:</label></td>
                    <td><input type="text" name="searchText" value="${searchText}" }/></td>
                    <td><input type="submit" value="Hledat" class="add-button"></td>
                    <td>
                        <a href="${customerListLink}">
                            <input type="button" value="Zrušit filtr" class="add-button">
                        </a>
                    </td>
                </tr>
            </form:form>
            <table>
                <tr>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Email</th>
                    <th>Akce</th>
                </tr>

                <c:forEach var="tempCustomer" items="${customers}">

                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <c:set var="alertTitle"
                           value="Vážně chcete smazat uživazatele ${not empty tempCustomer.firstName ? tempCustomer.firstName :''}${not empty tempCustomer.firstName && not empty tempCustomer.lastName ? ' ' :''}${not empty tempCustomer.lastName ? tempCustomer.lastName :''}?"/>

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
                            <a href=" ${updateLink}">Upravit</a>
                            |
                            <a href="${deleteLink}" onclick="if(!(confirm('${alertTitle}'))) return false">Smazat</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>