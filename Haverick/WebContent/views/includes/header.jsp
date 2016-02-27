<html>
<head>
<title>Haverick</title>

</head>
<body>
<div id="header">
<nav class="navbar">
	<h1>Haverick Logo</h1>
	<div id="navbar" class="navbar-collapse collapse">
	<ul class="nav navbar-nav">
		<%if(session.getAttribute("email")!=null){ %>
			<li><a href="<%=request.getContextPath()%>/LogoutAction">Logout</a></li>
		<%}else{ %>
			<li><a href="<%=request.getContextPath()%>/views/login.jsp">Login</a></li>
			<li><a href="<%=request.getContextPath()%>/views/register.jsp">Register</a></li>
		<%}%>
	</ul>
	</div>
</nav>
<hr>
</div>




