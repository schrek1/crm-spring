<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="header">
    <span style="float: left;"><h2>CRM - Customer Relationship Manager</h2></span>
    <span style="float: right;">
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Odhlásit se" class="add-button" style="margin-right: 10px;">
        </form:form>
    </span>
    <div style="clear:both;"></div>
</div>




