<%-- 
    Document   : createNewAccount
    Created on : Feb 27, 2018, 9:01:20 AM
    Author     : Trung Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="MainController" method="POST">
            <c:set var="errors" value="${requestScope.INSERTERROR}" />
            Username <input type="text" value="" name="txtUsername" />
            <c:if test="${not empty errors.usernamelengthErr}" >
                <font color="red">
                    Username is not empty
                </font>
            </c:if>
            Password <input type="text" value="" name="txtPassword" />
            Password Confirm <input type="text" value="" name="txtConfirm" />
            Full Name <input type="text" value="" name="txtFullName" />
            <input type="button" value="Create New Account" name="btnAction" />
        </form>
    </body>
</html>
