<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div id="header">
    <span style="float: left;"><h2>CRM - Customer Relationship Manager</h2></span>
    <span style="float: right;">
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Odhlásit se" class="add-button"/>
        </form:form>
    </span>
    <div style="clear:both;"></div>
</div>
<div id="header-login">
    <hr align="left"/>
    přihlášen uživatel: <security:authentication property="principal.username"/><br/>
    role: <security:authentication property="principal.authorities"/>
    <hr align="left"/>
</div>





