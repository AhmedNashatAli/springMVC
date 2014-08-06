<%-- 
    Document   : employeeForm
    Created on : May 27, 2013, 9:04:31 AM
    Author     : Ahmed Nashaat OLC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <style>
            .error {
                color: red;
            }
        </style> 
    </head>
    <body>

        <form:form action="saveEmployee.htm" commandName="employee" method="post">
            First Name <form:errors path="firstName" cssClass="error"/><form:input path="firstName" size="25" maxlength="50" cssClass="form_data"/><br>
            Last Name <form:errors path="lastName" cssClass="error"/><form:input path="lastName" size="25" maxlength="50" cssClass="form_data"/><br>
            Salary <form:errors path="salary" cssClass="error"/><form:input path="salary" size="25" maxlength="50" cssClass="form_data"/><br>
            <input type="submit" value="Save">
        </form:form>

    </body>
</html>
