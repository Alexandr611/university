<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
      <jsp:include page="_header.jsp"></jsp:include>
 
      <h3>Edit Product</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty company}">
         <form method="POST" action="${pageContext.request.contextPath}/editCompany">
            <input type="hidden" name="id" value="${company.id}" />
            <table border="0">
                  <td>Name</td>
                  <td><input type="text" name="name" value="${company.name}" /></td>
               </tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/companyList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
 
   </body>
</html>