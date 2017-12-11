<!DOCTYPE html>
<html>
<jsp:include page="_header.jsp"></jsp:include>

<h3>Login Page</h3>
<p style="color: red;">${errorString}</p>


<form method="POST" action="${pageContext.request.contextPath}/signUp">
	<table border="0">
		<tr>
			<td>User Name</td>
			<td><input type="text" name="userName" value="${user.userName}" />
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"
				value="${user.password}" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="repassword"
				value="${user.password}" /></td>
		</tr>
		<tr>
			<td>Sex</td>
			<td><input type="radio" name="gender" value="M"> Male<br>
				<input type="radio" name="gender" value="F"> Female<br></td>
		</tr>
		<tr>
			<td>Remember me</td>
			<td><input type="checkbox" name="rememberMe" value="Y" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /> <a
				href="${pageContext.request.contextPath}/">Cancel</a></td>
		</tr>
	</table>
</form>

<p style="color: blue;">User Name: tom, password: tom001 or
	jerry/jerry001</p>

<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>