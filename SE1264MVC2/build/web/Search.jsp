<%-- 
    Document   : Search
    Created on : Jan 30, 2018, 7:11:57 AM
    Author     : Trung Nhan
--%>

<%@page import="nhannt.dao.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1> 
            <%-- 
                Cookie[] cookies = request.getCookies();
                String username = "";
                if (cookies != null) {
                         username = cookies[cookies.length-1].getName();
                    }
            --%>
            Welcome, ${sessionScope.USERNAME}
        </h1>
        <h3>Search Page</h3>
        <form method="POST" action="MainController">

            Search value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}"/>
            <input type="submit" value="Search" name="btnAction" />

        </form> 
        </br>
        <%--  <%
              String searchValue = request.getParameter("txtSearchValue");

            if (searchValue != null) {
                List<StudentDTO> result = (List<StudentDTO>) request.getAttribute("SEARCHRESULT");

                if (result != null) {
        %> --%>
        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}" >
            <c:set var="result" value="${requestScope.SEARCHRESULT}" />
            <c:if test="${not empty result}" >

                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>LastName</th>
                            <th>Role</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.username}
                                    <input type="hidden" name="txtUsername" value="${dto.username}" />
                                    
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" value="${dto.password}" />
                                </td>
                                <td>${dto.lastname}
                                    <input type="hidden" name="txtLastName" value="${dto.lastname}" />

                                </td>
                                <td>
                                    <input type="checkbox" name="chkAdmin" value="ON"
                                           <c:if test="${dto.isAdmin}">
                                               checked="checked"
                                           </c:if>
                                           />
                                </td>
                                <td>
                                    <c:url var="deleteRecord" value="MainController">
                                        <c:param name="btnAction" value="Delete" />
                                        <c:param name="pk" value="${dto.username}" />
                                    </c:url><a href="${deleteRecord}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btnAction" />
                                    <input type="hidden" value="${searchValue}" name="lastSearchValue"/>
                                </td>
                            </tr>

                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>No record is matched</h2>
        </c:if>
    </c:if>
    <%--
<table border="1">
  <thead>
      <tr>
          <th>No.</th>
          <th>Username</th>
          <th>Lastname</th>
          <th>Role</th>
      </tr>
  </thead>
  <tbody>
      <%
          int count = 0;
          for (StudentDTO dto : result) {
              String urlRewriting = "MainController"
                      + "?btnAction=delete"
                      + "&pk="
                      + dto.getUsername()
                      + "&lastSearchValue="
                      + searchValue;
      %>
  <form action="MainController" method="POST">              
      <tr>
          <td><%= ++count%></td>
          <td>
              <%= dto.getUsername()%>
              <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>" />
          </td>
          <td>
              <%= dto.getLastname()%>
              <input type="hidden" name="txtLastName" value="<%= dto.getLastname()%>" />
          </td>
          <td>
              <input type="checkbox" name="chkAdmin" value="ON" 
                     <%
                         if (dto.isIsAdmin()) {
                     %>
                     checked="checked"
                     <%
                         }
                     %>
                     />
          </td>
          <td>
              <a href="<%= urlRewriting%>">Delete</a>
          </td>
          <td>
              <input type="submit" value="Update" name="btnAction" />
              <input type="hidden" name="lastSearchValue" 
                     value="<%= searchValue%>"  />

                    </td>
                </tr>
            </form>

            <%
                }
            %>

        </tbody>
    </table>

    <%
    } else {
    %>
    <h2>No Record </h2>
    <%
            }
        }//end if searchvalue
%>--%>
</body>
</html>
