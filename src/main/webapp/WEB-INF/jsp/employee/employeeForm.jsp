<%-- 
    Document   : employeeForm
    Created on : May 27, 2013, 9:04:31 AM
    Author     : Ahmed Nashaat OLC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <c:set var="employeePhonesCount" value="${fn:length(employee.phones)}"/>
        <script>
            var i=${employeePhonesCount==0?1:employeePhonesCount};
          $("#addMore").ready(function (){
                $("#addMore").click(function(){
                var input=$('<input></input>').attr('type','text').addClass("form_data").attr('name',"phones["+i+"].number").attr('id',"phones"+i+".number");
                 $(this).before(input);
                 $(this).before("<br>");
                 input.before("Phone"+i+"");
                 i++;
            });
          })
           
        </script>
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
            Email <form:errors path="email" cssClass="error"/><form:input path="email"  cssClass="form_data"/><br>
            Salary <form:errors path="salary" cssClass="error"/><form:input path="salary" size="25" maxlength="50" cssClass="form_data"/><br>
            <c:choose>
                <c:when test="${! empty employee.phones}">
                     <c:forEach items="${employee.phones}" var="phon" varStatus="i" >
              Phone${i.index} <form:errors path="phones[${i.index}].number" cssClass="error"/><form:input path="phones[${i.index}].number" size="25" maxlength="50" cssClass="form_data"/><br>
            </c:forEach>
                </c:when>
            <c:otherwise>
                  Phone0 <form:errors path="phones[0].number" cssClass="error"/><form:input path="phones[0].number" size="25" maxlength="50" cssClass="form_data"/><br>
            </c:otherwise>
            </c:choose>
           
            <input type="button" value="Add More Phones" id="addMore"/>
            <input type="submit" id="saveButton" value="Save">
        </form:form>

    </body>
</html>
