$( document ).ready(function() {
    var sum = 0;
    var select_val ;

    
	//onclick
	$('#form-1-button').click(function() {
		$.post(
		
			"/get-product-by-barcode",
			{
				barcode: $("#form-1-adder-input").val(),
		
			},
			onAjaxSuccess
			
			);
		
		function onAjaxSuccess(data)
		{
			$('#form-2-adder').append(" <div class='col-md-6'> <input type='text' value='"+data.name+"' name='"+data.id+"' class='form-control' readonly/></div>" +
			"  <div class='col-md-2'> <select  id='"+data.price+"' name='"+data.barcode+"' class='form-control' > <option value='1'> 1 </option> </select> </div> "); 
			
			
			//values 1 - 100
			var $select = $("select[name='"+data.barcode+"']");
			for (i=2;i<=100;i++){
			   $select.append('<option value='+i+' > '+i+'</option>');
			   
			}
			
			
			$('#form-1-adder-input').val('');
			
			//adding all but ...
			sum = sum + parseInt(data.price);
			
			$('#sum').html(sum);
		}
		$('#form-1-adder-input').val('');
		$('#form-1-adder-input').focus();
	});
	//always focus
	$('#form-1-adder-input').focus();
	$('#form-1-adder-input').focusout(function(){
       $('#form-1-adder-input').focus();
    });
	
	$('#form-2-adder').on('change', 'select', function(){
		sum = 0;
		$('select').each(function() {
			var counter_2 = parseInt($(this).val());
			var price_2 = parseInt($(this).attr('id'));
			sum = sum + counter_2 * price_2;
		});
	
		$('#sum').html(sum);
		
//		var counter = parseInt($(this).val());
//		if (counter > 1){
//			// actually this is a PRICE
//			var id = parseInt($(this).attr('id'));
//			
//			sum = sum + (counter - 1) * id;
//		
//			$('#sum').html(sum);
//		}
		
	});
		
			
});
