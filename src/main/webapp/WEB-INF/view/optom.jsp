<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Optom</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
    
   
</head>
<body>
<div class="container-fluid">

<a href="${pageContext.request.contextPath}/menu" class="btn btn-primary"> -- Orqaga </a>
<a href="${pageContext.request.contextPath}/optom/list" class="btn btn-primary"> Ichimliklar </a>
<a href="${pageContext.request.contextPath}/agents/add" class="btn btn-primary"> Agent qo'shish </a>
<a href="${pageContext.request.contextPath}/clients/add" class="btn btn-primary">Client qo'shish</a>
<br><br>

 <div class="col-md-12">
  <div class="col-md-6">
<label for="agent">Agent</label>
<select id="agent" class="form-control" style="font-size:20px;font-weight:bold;"> 
<c:forEach items="${agents}" var="ag">
<option value="${ag.name} ${ag.phone}" > ${ag.name} , ${ag.phone}</option>
</c:forEach>
</select>
 <br>
 </div>
  <div class="col-md-6">
 <label for="client">Client</label>
<select id="client" class="form-control" style="font-size:20px;font-weight:bold;"> 
<c:forEach items="${clients}" var="cl">
<option value="${cl.name} ${cl.phone}" > ${cl.name} , ${cl.phone}</option>
</c:forEach>
</select>
</div>
</div>

 <form onsubmit="return false">
 <div class="col-md-12">
 <div class="col-md-4">
 <label for="name">Nomi</label>
    <select class="form-control" id="name" style="font-size:20px;font-weight:bold;">
    <option> -- </option>
    	<c:forEach items="${list}" var="temp">
    		<option value="${temp.id }" id="${temp.id }" data-kg="${temp.weight }" data-price="${temp.price }"> ${temp.name }</option>
    	</c:forEach>
    </select>
    </div>
    
    <div class="col-md-3"><label for="pack">Pachka</label><input id="pack" type="number" class="form-control" style="font-size:20px;font-weight:bold;"></div>
    <div class="col-md-3"><label for="quant">Soni</label><input id="quant" type="number" class="form-control" style="font-size:20px;font-weight:bold;"></div>
  
    <div class="col-md-2"><button class="btn btn-primary" id="optom_add">+</button></div>
 </div>
  </form>
  
  <table id="optom_table" class="table table-striped">
  	<thead>
  		<tr>
  				<th>Tovar nomi</th>
  				<th>Pachka</th>
  				<th>Soni</th>
  				<th>Narxi</th>
  				<th>Summa</th>
  				<th>KG</th>
  		</tr>	
  	</thead>
  	<tbody>
  		
  	</tbody>
  </table>
  <div class="col-md-12">
  	<div class="col-md-4">
  		<h2>Jami</h2>
  	</div>
  	<div class="col-md-2"><h2 id="pachok"></h2><h3>Pachka</h3></div>
  	<div class="col-md-2"><h2 id="sani"></h2><h3>Soni</h3></div>
  	<div class="col-md-2"><h2 id="summi"></h2><h3>Narxi</h3></div>
  	<div class="col-md-2"><h2 id="kigi"></h2><h3>Kilosi</h3></div>
  	
  </div>
  <form  id="ohirgi" action="${pageContext.request.contextPath}/optom/json" >
  	<input id="malumot" name="malumot" hidden >
  	<input id="tablitsa" name="tablitsa" hidden>
	  <input id="tugatish" type="submit" class="btn btn-primary" value="Tugatish">
	  
	  
  </form>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/optom_scripts.js"></script>

</body>
</html>