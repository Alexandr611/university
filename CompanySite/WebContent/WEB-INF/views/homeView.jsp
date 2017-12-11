<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="_header.jsp"></jsp:include>
    
      <h3>Home Page</h3>
      
      <ul class="nav navbar-nav ">
					<li ><a href="">Home</a></li>
					<li class="active"><a href="companyList">Main</a></li>
					<li><a href="userInfo">info</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Account <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="login">Login</a></li>
							<li><a href="signUp">Sign up</a></li>
						</ul></li>
				</ul>
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>