$( document ).ready(function() {
    var sum = 0;
    
    
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
			"  <div class='col-md-2'> <input type='number' class='form-control' name='"+data.barcode+"' value='1'/> </div> "); 
			$('#form-1-adder-input').val('');
			
			sum = sum + (parseInt(data.price) *  parseInt($( "input[name='"+data.barcode+"']" ).val()));
			
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
	
	

	
	
	
});
