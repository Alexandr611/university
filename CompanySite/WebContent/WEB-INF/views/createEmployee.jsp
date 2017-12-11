<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<jsp:include page="_header.jsp"></jsp:include>

<h3>Create Employee</h3>

<p style="color: red;">${errorString}</p>


<form method="POST" id="form"
	action="${pageContext.request.contextPath}/createEmployee?id=${id}">
	<table border="0">
		<tr>
			<td>first name</td>
			<td><input type="text" name="firstName" /> <input
				type="hidden" name="id">
				 <div id="firstName_error"></div>
				</td>
		</tr>
		<tr>
			<td>last name</td>
			<td><input type="text" name="lastName" />
			<div id="lastName_error"></div>
			</td>
		</tr>
		<tr>
			<td>post</td>
			<td><select name="post">
					<option>choose post</option>
					<option value="junior" selected>junior</option>
					<option value="midle">middle</option>
					<option value="senior">senior</option>
			</select></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="email" name="email" required/>
			<div id="email_error"></div></td>
		</tr>
		<tr>
			<td>phone number</td>
			<td><input type="tel" name="phone" required/>
			<div id="tel_error"></div>
			</td>
		</tr>
		<tr>
			<td>salary</td>
			<td><input type="number" name="salary" required/>
			<div id="salary_error"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"
				name="register" id="createEmp" value="Register" /> <a href="companyList">Cancel</a></td>
		</tr>
	</table>
</form>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>