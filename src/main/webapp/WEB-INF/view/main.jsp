
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
<h1> SAVDO </h1>

<a href="${pageContext.request.contextPath}/menu" class="btn btn-primary"> MENU </a>
<br><br>
	
	<div class="col-md-12">
	<div class="col-md-8"> 
		<form onsubmit="return false" id="form-1-adder">
		     <div class="col-md-6"> <input type="text" class="form-control" id="form-1-adder-input" /></div>
		     <div class="col-md-2"> <button id="form-1-button" type="submit"  class="btn btn-primary" >Qo'shish</button>    </div>
		</form>
	</div>
	</div>
	<br><br>
<div class="alert alert-warning alert-dismissible fade in" hidden="true" id="alert"><p id="info">Mahsulot topilmadi</p></div>


	<div class="col-md-12">
	<div class="col-md-10" style="border-style:solid;border-width:2px;border-color:#337AB7;height:500px;"> 
		
		<form id="form-2-adder" method="POST" action="${pageContext.request.contextPath}/saveHisob">
			
			<input type="hidden" id="sum_final" name="sum_final"/>
			<input type="hidden" id="product_count" name="product_count"/>
			<input type="hidden" id="printerflag" name="printerflag" value="1"/>
			
			
			
		    <input type="submit" id="form-2-button" class="btn btn-primary" value="Yakunlash"/>
		    <br><br>
		    
		</form>
		

	</div>
	<div class="col-md-2"> 
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<p id="sum" class="result_style"></p><span class="result_style">so'm</span>
	 </div>
	 
	</div>


</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
 
</body>
</html>
