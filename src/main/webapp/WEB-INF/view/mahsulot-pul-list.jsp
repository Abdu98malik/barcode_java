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
   <link href="${pageContext.request.contextPath}/css/datatables.css"  rel="stylesheet">
</head>
<body>
<div class="container">
<h1> Kunlik savdo </h1>

<a href="${pageContext.request.contextPath}/menu" class="btn btn-primary"> MENU </a>
<a href="${pageContext.request.contextPath}/mahsulot-pul/excel" class="btn btn-primary"> EXCEL </a>

<br><br>
	
<br>

<table class="display table" id="kunliksavdo">

<thead> 
<tr>
	<th>Sana</th>
	<th>Pul</th>
</tr>
</thead>

<tbody>
	<c:forEach items="${list}" var="temp">
		<tr>
			<td> <b>${temp.date_time }</b></td>
			<td><b> ${temp.money }</b></td>
		</tr>
	</c:forEach>
</tbody>


</table>

</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="${pageContext.request.contextPath}/js/datatables.js"></script>
 <script type="text/javascript">
$(document).ready(function() {
    $('#kunliksavdo').DataTable();
});
</script>
</body>
</html>
