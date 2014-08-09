<%-- 
    Document   : employeeForm
    Created on : May 27, 2013, 9:04:31 AM
    Author     : Ahmed Nashaat OLC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
        <div style="float: right"><a href="employeeForm.htm?lang=en">English</a>|<a href="employeeForm.htm?lang=ar">عربى</a></div>
        <form:form action="saveEmployee.htm" commandName="employee" method="post">
            <spring:message code="employee.form.firstName"/> <form:input path="firstName" size="25" maxlength="50" cssClass="form_data"/><br>
            <form:errors path="firstName" cssClass="error"/><br>
            <spring:message code="employee.form.lastName"/><form:input path="lastName" size="25" maxlength="50" cssClass="form_data"/><br> 
            <form:errors path="lastName" cssClass="error"/><br>
            <spring:message code="employee.form.email"/> <form:input path="email"  cssClass="form_data"/><br>
            <form:errors path="email" cssClass="error"/><br>
            <spring:message code="employee.form.salary"/> <form:input path="salary" size="25" maxlength="50" cssClass="form_data"/><br>
            <form:errors path="salary" cssClass="error"/><br>
            <input type="submit" value="<spring:message code="employee.form.save"/>">
        </form:form>

    </body>
</html>
