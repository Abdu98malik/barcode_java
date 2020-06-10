<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SAVDO</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/styles.css"
        rel="stylesheet">        
</head>
<body>
<div class="container">
<h1> Kunlik savdo </h1>

<a href="${pageContext.request.contextPath}/menu" class="btn btn-primary"> MENU </a>
<br><br>
	


<p>${pul.money }</p>



</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="/js/scripts.js"></script>
 
</body>
</html>