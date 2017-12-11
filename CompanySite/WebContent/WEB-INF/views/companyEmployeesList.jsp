<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <jsp:include page="_header.jsp"></jsp:include>
 
    <h3>List of employees</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" class="view" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Code</th>
          <th>post</th>
          <th>phone number</th>
          <th>email</th>
          <th>first name</th>
          <th>last name</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${company.employees}" var="employee" >
          <tr>
             <td>${employee.getId()}</td>
             <td>${employee.post}</td>
             <td>${employee.phoneNumber}</td>
             <td>${employee.email}</td>
             <td>${employee.firstName}</td>
             <td>${employee.lastName}</td>
             <td>
                <a href="editeEmployee?id=${employee.id}"><span class="glyphicon glyphicon-cog"></span></a>
             </td>
             <td>
                <a href="deleteEmployee?id=${employee.id}"><span class="glyphicon glyphicon-trash"></span></a>
             </td>
          </tr>
       </c:forEach>
           <p><a href="createEmployee?id=${id}" class="create" >Create employee</a></p>
    </table>
 

 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>