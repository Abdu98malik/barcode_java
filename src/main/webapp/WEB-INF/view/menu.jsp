<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body>

<div class="container">

 <div class="col-md-4"><h1 style="color:blue;">Ichimliklar do'koni</h1>
 <br><br>
 <a href="${pageContext.request.contextPath}/" class="btn btn-primary btn-lg">SAVDO</a><br>
<br> <a href="${pageContext.request.contextPath}/products/list" class="btn btn-primary btn-lg">Ichimliklar ombori</a><br>
  <br><a href="${pageContext.request.contextPath}/mahsulot-pul/list" class="btn btn-primary btn-lg">Kunlik savdo</a>
 
 
 </div>
<div class="col-md-8">
<img src="${pageContext.request.contextPath}/napitki.jpg" style="width:800px; height:600px; ">
</div>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>