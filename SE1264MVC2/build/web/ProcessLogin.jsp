<%-- 
    Document   : ProcessLogin
    Created on : Feb 8, 2018, 7:13:24 AM
    Author     : Trung Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Process Login....</h1>
        <%--
        <jsp:useBean id="login" class="nhannt.bean.LoginBean" />
        <jsp:setProperty name="login" property="username" value='<%= request.getParameter("txtUsername") %>'/>
        <jsp:setProperty name="login" property="password" value='<%= request.getParameter("txtPassword") %>'/>
        --%>
        
        <%--
        <jsp:setProperty name="login" property="username" param="username"/>
        <jsp:setProperty name="login" property="password" param="password"/>
        --%>
        
        <jsp:setProperty name="login" property="*" />
        
        Test: <br/>
        Username: <jsp:getProperty name="login" property="username" /> <br/>
        Password: <jsp:getProperty name="login" property="password" /> <br/>
        
    </body>
</html>
