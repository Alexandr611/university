<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="_header.jsp"></jsp:include>

	<h3>Edite employee</h3>

	<p style="color: red;">${errorString}</p>
	<c:if test="${not empty employee}">
		<form method="POST"
			action="${pageContext.request.contextPath}/editeEmployee?id=${employee.id}">
			<table border="0">
				<tr>
					<td>first name</td>
					<td><input type="text" name="firstName"
						value="${employee.firstName}" /> <input type="hidden" name="id"
						value="${id}">
						 <div id="firstName_error"></div>
						</td>
				</tr>
				<tr>
					<td>last name</td>
					<td><input type="text" name="lastName"
						value="${employee.lastName}" />
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
					<td><input type="email" name="email" value="${employee.email}" />
					 <div id="email_error"></div></td>
				</tr>
				<tr>
					<td>phone number</td>
					<td><input type="tel" name="phone"
						value="${employee.phoneNumber}" />
						 <div id="tel_error"></div></td>
				</tr>
				<tr>
					<td>salary</td>
					<td><input type="text" name="salary"
						value="${employee.salary}" />
						 <div id="salary_error"></div>
						</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /> <a
						href="companyList">Cancel</a></td>
				</tr>
			</table>
		</form>
	</c:if>
	<c:if test="${empty employee}">
		<form method="POST" id="form"
			action="${pageContext.request.contextPath}/editeEmployee?id=${id}">
			<table border="0">
				<tr>
					<td>first name</td>
					<td><input type="text" name="firstName"
						value="${employee.firstName}" /> <input type="hidden" name="id"
						value="${id}">
						 <div id="firstName_error"></div>
						</td>
				</tr>
				<tr>
					<td>last name</td>
					<td><input type="text" name="lastName"
						value="${employee.lastName}" />
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
					<td><input type="email" name="email" value="${employee.email}" />
					 <div id="email_error"></div>
					</td>
				</tr>
				<tr>
					<td>phone number</td>
					<td><input type="tel" name="phone"
						value="${employee.phoneNumber}" />
						 <div id="tel_error"></div>
						</td>
				</tr>
				<tr>
					<td>salary</td>
					<td><input type="text" name="salary"
						value="${employee.salary}" />
						 <div id="salary_error"></div>
						</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /> <a
						href="companyList">Cancel</a></td>
				</tr>
			</table>
		</form>
	</c:if>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>