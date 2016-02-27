<%
if(session.getAttribute("email")!=null){
	response.sendRedirect(request.getContextPath() + "/views/secure/index.jsp");
}
else{
	response.sendRedirect(request.getContextPath() + "/views/index.jsp");
}
%>