<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products list</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/datatables.css"  rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Mahsulotlar</h1>
<br>
<a href="${pageContext.request.contextPath}/" class="btn btn-primary"> -- Orqaga </a>
<br><br>
<a href="${pageContext.request.contextPath}/products/add-form" class="btn btn-danger"> Yangi Mahsulot qo'shish</a>
<br><br>
<table class="display table" id="products">
<thead>
	<tr> 
	 	<th> ID</th>
	 	<th> Barcode</th>
	 	<th> Nomi</th>      
	 	<th> Narxi </th>    
	 	<th> Soni </th>
	 	<th> </th>
	 </tr>
	 </thead>
	 <tbody>
	 <c:forEach items="${products}" var="temp">
		 <c:url var="updateLink" value="${pageContext.request.contextPath}/products/edit-form">
			<c:param name="productId" value="${temp.id}">   
			</c:param>
		</c:url>
	
	 	<tr>
	 		<td><b>${temp.id}</b></td>
	 		<td><b>${temp.barcode}</b></td>
	 		<td><b>${temp.name}</b></td>
	 		<td><b>${temp.price} So'm</b></td>
	 		<td><b>${temp.quantity}</b></td>
	 		<td><a href="${updateLink}" class="btn btn-danger btn-sm" >O'zgartirish</a></td>
	 	</tr>
	 </c:forEach>
</tbody>
</table>

</div><br><br><br><br><br>

 <script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datatables.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#products').DataTable();
} );
</script>
</body>
</html>