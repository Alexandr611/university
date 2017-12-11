<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <jsp:include page="_header.jsp"></jsp:include>
 
    <h3>Companies List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table class="view" border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Code</th>
          <th>Name</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${companyList}" var="company" >
          <tr>
             <td>${company.id}</td>
             <td> <a href="company?id=${company.id}&name=${company.name}">${company.name}</a></td>
             <td>
                <a href="editCompany?id=${company.id}"><span class="glyphicon glyphicon-cog"></span></a>
             </td>
             <td>
                <a href="deleteCompany?id=${company.id}"><span class="glyphicon glyphicon-trash"></span></a>
             </td>
          </tr>
       </c:forEach>
        <p><a href="createCompany" class="create">Create company</a></p>
    </table>
 
   
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>