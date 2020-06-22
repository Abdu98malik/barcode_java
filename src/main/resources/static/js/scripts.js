$( document ).ready(function() {
    var sum = 0;
    var count_not_final = 0;
    var global_product_counter = 0;
    
	//onclick
	$('#form-1-button').click(function() {
		$.post(
		
			"http://localhost:8080/get-product-by-barcode",
			{
				barcode: $("#form-1-adder-input").val(),
		
			},
			onAjaxSuccess
			
			);
		
		function onAjaxSuccess(data)
		{
			if(data ){
			//<input type='text' value='"+data.name+"' name='"+data.id+"' class='form-control' readonly/>
//			$('select').each(function() {
//				var select_name = $('select[name="'+data.barcode+'"]');
//				if(select_name){
//					var soni = select_name.val();
//					select_name.val(soni + 1);
//				}else{}
//			});border-bottom-style: solid;
				//border-width: 2px;
		//	padding-bottom: 3px;
			
			$('#form-2-adder').append(" <div id='"+data.barcode+"' >  <div class='col-md-6' ><button id='"+data.barcode+"'  type='button' class='button_remove'> - </button> <span class='name_style'>"+data.name+"</span></div>" +
			"  <div class='col-md-2'> <select  id='"+data.price+"' name='"+ data.barcode +"' class='form-control' > <option value='1'> 1 </option> </select> </div> </div>"); 
			
			
			//values 1 - 100
			var $select = $("select[name='"+data.barcode+"']");
			for (i=2;i<=100;i++){
			   $select.append('<option value='+i+' > '+i+'</option>');
			   
			}
			
			
			$('#form-1-adder-input').val('');
			count_not_final = count_not_final + 1;
			global_product_counter = count_not_final;
			//adding all but ...
			sum = sum + parseInt(data.price);
			
			$('#product_count').val(count_not_final);
			$('#sum').html(sum);
			$('#sum_final').val(sum);	
			$('#alert').hide();
			}else{
				$('#alert').show();
		
			}
			
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
		sum = 0; var counter = 0; 
		$('select').each(function() {
			var counter_2 = parseInt($(this).val());
			var price_2 = parseInt($(this).attr('id'));
			sum = sum + counter_2 * price_2;
			counter = counter + 1; 
		});
	
		$('#sum').html(sum);
		$('#sum_final').val(sum);	
		global_product_counter = counter;
		$('#product_count').val(counter);
	});
	
	$(document).keydown(function(event){
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '119'){ // f8
			event.preventDefault();
	        $('#form-2-adder').trigger('submit');
	    }
	});  

	$('#form-2-adder').on('click', 'button[type="button"]', function(){
		var id_of_btn = $(this).attr('id');
		
		var price_of_current = $('select[name='+ id_of_btn +']').attr('id');
		var count_of_current =  $('select[name='+ id_of_btn +']').val();
		sum = sum - (price_of_current * count_of_current); 
		
		global_product_counter = global_product_counter - 1 ;
		$('#product_count').val(global_product_counter);
		
		$('#sum').html(sum);
		$('#sum_final').val(sum);	
		
		$('div[id=' + id_of_btn + ']').remove();
	});
	
	$('#form-2-button').click(function (e) {
	    var r = confirm("Print ???");
	    if (r == true) {
	    	$('#printerflag').val("1");
	    	$('#form-2-adder').trigger('submit');
	    } else {
	    	$('#printerflag').val("0");
	    	$('#form-2-adder').trigger('submit');
	    }
	    e.preventDefault();
	});
	
});
