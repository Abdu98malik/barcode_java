<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ishchilar add form</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
        
</head>
<body>

<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="/js/scripts.js"></script>
 
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
	
<div id="info"></div>
<br><br><br>

	<div class="col-md-12">
	<div class="col-md-8"> 
		<form id="form-2-adder" method="GET">
		
			<!--  <div class="col-md-6"> <input type="text" class="form-control" readonly/></div>
		     <div class="col-md-2"> <input type="number" class="form-control" value="1"/> </div>-->
			
		    <button type="submit" id="form-2-adder" class="btn btn-danger" > Yakunlash </button>
		</form>

	</div>
	<div class="col-md-4"> 
		<p id="sum"></p>
	 </div>
	 
	</div>



</div>

</body>
</html>
