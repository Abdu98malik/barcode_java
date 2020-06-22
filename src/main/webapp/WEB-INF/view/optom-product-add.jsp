<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add form</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body>


<div class="container">
<h1> Yangi mahsulot qo'shish </h1><br>
<br>
<a href="${pageContext.request.contextPath}/optom/list" class="btn btn-primary"> -- Orqaga </a>
<br><br>

<div class="col-md-3">

	<form:form action="${pageContext.request.contextPath}/optom/save" modelAttribute="products" method="POST">
		<form:hidden path="id" />
		<h4>To'liq Nomi:</h4> 
		<form:input path="name" class="form-control"/>
		<br>
		<h4>Narxi:</h4> 
		<form:input path="price" class="form-control"/>
		<br>
		<h4>Og'irligi:</h4> 
		<form:input path="weight" class="form-control"/>
		<br>
		
		<input type="submit" value="Saqlash" class="btn btn-danger"/>
	</form:form>
</div>

</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 
</body>
</html>