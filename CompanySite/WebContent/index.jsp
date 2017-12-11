<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="/CompanySite/teamplates/css/style.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<form class="navbar-form navbar-right" method="POST"
					action="${pageContext.request.contextPath}/search" role="search">
					<div class="form-group">
						<input type="text" name="search" class="form-control"
							placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Send</button>
				</form>
				<ul class="nav navbar-nav ">
					<li ><a href="/CompanySite/">Home</a></li>
					<li class="active"><a href="companyList">Main</a></li>
					<li><a href="userInfo">info</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Account <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="login">Login</a></li>
							<li><a href="signUp">Sign up</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<h2>CompanySite</h2>
	<ul class="nav navbar-nav ">
		<li class="active"><a href="companyList">Main</a></li>
		<li><a href="userInfo">info</a></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown">Account <b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="login">Login</a></li>
				<li><a href="signUp">Sign up</a></li>
			</ul></li>
	</ul>
	<div id="footer">
		<div class="container-fluid">
			<p class="text-muted">Company Site.</p>
			<p>
				<a href="smalinovsky@mail.ua">@smalinovsky@mail.ua</a>
			</p>
		</div>
	</div>
</body>
</html>