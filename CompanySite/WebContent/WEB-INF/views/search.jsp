<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
 
 
    <p style="color: red;">${errorString}</p>
	<table class="view" border="1" cellpadding="5" cellspacing="1">
	<tr>
		<th>Company</th>
		<th>Employee name</th>
		<th>Employee last name</th>
		<th>Employee post</th>
		<th>Email</th>
	</tr>
       <c:forEach items="${find}" var="f" >
          <tr>
             ${f}
          </tr>
       </c:forEach>
 	</table>
   
 
    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>