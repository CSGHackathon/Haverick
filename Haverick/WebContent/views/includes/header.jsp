<!DOCTYPE HTML>
<html>
<head>
<title>Haverick</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all" />
<link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' media="all" />
<link href="<%=request.getContextPath()%>/css/custom.css" rel='stylesheet' type='text/css'/>
<script src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<link href='//fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html"><h1><img src="<%=request.getContextPath()%>/images/logo.png" alt="" /></h1></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
			<div class="top-search">
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
					<input type="submit" value=" ">
				</form>
			</div>
			<%if(session.getAttribute("email")!=null){%>
				<jsp:include page="../secure/includes/nav.jsp"/>
			<%}else {%>
				<jsp:include page="nav.jsp"/>
			<%} %>
			
        </div>
		<div class="clearfix"> </div>
      </div>
    </nav>
    <%if(session.getAttribute("email")!=null){%>
		<jsp:include page="../secure/includes/sidebar.jsp"/>
	<%}%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="show-top-grids">
			




