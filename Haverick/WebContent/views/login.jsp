<jsp:include page="includes/header.jsp"/>
<h1>Login</h1>
<form action="<%=request.getContextPath()%>/LoginAction" type="post">
<label for="email">Email:</label>
<input type="email" name="email" placeholder="email"></input>
<label for="password">Password:</label>
<input type="password" name="password"></input>
<input type="submit"></input>
</form>
<jsp:include page="includes/footer.jsp"/>