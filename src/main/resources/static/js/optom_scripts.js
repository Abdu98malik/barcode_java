$(document).ready(function(){
	var global_sum = 0;
	var global_pachka = 0;
	var global_kilo = 0.0;
	var global_soni = 0;
	
	$('#optom_add').click(function(){
		var val = $('#name').val();
		
		var price = $('#'+val+'').data("price");
		var weight = $('#'+val+'').data("kg");
		var name = $('#'+val+'').html();
		var pachka = $('#pack').val();
		var soni = $('#quant').val();
		var sum = parseInt(soni) * parseInt(price);
		var ogirligi = (parseInt(soni) * parseInt(weight))/1000;
		
		global_sum = global_sum + sum;
		global_pachka = global_pachka + parseInt(pachka);
		global_kilo = global_kilo + ogirligi;
		global_soni = global_soni + parseInt(soni);
		
		$('#optom_table').append("<tr> <td><strong style='font-size: 20px;'>"+name+"</strong></td> " +
				"<td> <strong style='font-size: 20px;'>"+pachka+"</strong></td>" +
						"<td><strong style='font-size: 20px;'>"+soni+"</strong></td>" +
								"<td><strong style='font-size: 20px;'>"+price+"</strong></td>" +
		"<td> <strong style='font-size: 20px;'>"+sum+"</strong></td>" +
				"<td><strong style='font-size: 20px;'> "+ogirligi+"</strong></td></tr>");
	
		$('#pachok').html(global_pachka);
		$('#sani').html(global_soni);
		$('#summi').html(global_sum);
		$('#kigi').html(global_kilo);
	});
	
	$('#ohirgi').submit(function(e){
		
		var agent = $('#agent').val();
		var client = $('#client').val();
		
		var str = '{' +
				'"agent":"'+agent + '", "client": "' + client + '", "pachka":"' +global_pachka+'","soni":"'   
				+global_soni+'", "kilo":"'+global_kilo+'", "sum":"'+global_sum+'" }';
		var tb = html2json();
		
		
//		$.post(
//				"http://localhost:8080/jsontable",
//				{
//					result:str,
//					table:tb,
//				}
//				
//		)
		
		$('#malumot').val(str);
		$('#tablitsa').val(tb);
		//e.preventDefault();
		//$('#ohirgi').submit();
		
	});
	
	function html2json() {
		   var json = '{';
		   var otArr = [];
		   var tbl2 = $('#optom_table tr').each(function(i) {        
		      x = $(this).children();
		      var itArr = [];
		      x.each(function() {
		         itArr.push('"' + $(this).text() + '"');
		      });
		      otArr.push('"' + i + '": [' + itArr.join(',') + ']');
		   })
		   json += otArr.join(",") + '}'

		   return json;
		}

});