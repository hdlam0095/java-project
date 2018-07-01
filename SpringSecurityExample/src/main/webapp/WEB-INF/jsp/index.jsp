<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
	<head>
		<title>SIMS - HỆ THỐNG QUẢN LÝ KHO</title>
		<jsp:include page="header.jsp"/>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			//Left menu
			//$(document).ready(function(){
				//$("ul#side-menu li ul li a").click(function(){
					//var page = $(this).attr("id");
					//alert(page);
					//$("#page-wrapper").load(page);
				//});
			//});
		//</script> 
	</head>
	<body>
		<div id="wrapper">
			<!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            	<jsp:include page="headmenu.jsp"/>
            	<jsp:include page="leftmenu.jsp"/>
            	
            
       </nav>
		<div id="page-wrapper">
		
			<!-- /.row -->
		</div>
	
	</div>
	<!-- /#wrapper -->
		
		<jsp:include page="footer.jsp"/>
</body>
</html>
