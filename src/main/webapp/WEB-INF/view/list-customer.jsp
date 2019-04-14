<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%--@elvariable id="searchText" type="java.lang.String"--%>
<%--@elvariable id="customers" type="java.util.List<cz.schrek.spring.mvc.crm.entity.Customer>"--%>


<c:url var="searchLink" value="/customer/search"/>
<c:url var="customerListLink" value="/customer/list"/>
<c:url var="adminConsoleLink" value="/admin"/>
<c:url var="managerDashboardLink" value="/manager"/>

<html>
<head>
    <title>Seznam zákazníků</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">

    <jsp:include page="secure-page-header.jsp"/>

    <div id="container">

        <input type="button" value="Přidat zákazníka" class="add-button"
               onclick="window.location.href='showFormForAdd'; return false" style="margin-top: 20px;">

        <security:authorize access="hasAuthority('MANAGER')">
            <input type="button" value="Manager board" class="add-button"
                   onclick="window.location.href='${managerDashboardLink}'; return false" style="margin-top: 20px;">

        </security:authorize>

        <security:authorize access="hasAuthority('ADMIN')">
            <input type="button" value="Admin console" class="add-button"
                   onclick="window.location.href='${adminConsoleLink}'; return false" style="margin-top: 20px;">
        </security:authorize>

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