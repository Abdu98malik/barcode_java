$( document ).ready(function() {
    
	$('#form-1-button').click(function() {
		$('#form-1-adder').append("<div class='col-md-6'> <input type='text' value='hello' class='form-control' readonly/></div>" +
				"  <div class='col-md-2'> <input type='text' class='form-control' value='1'/> </div> "); 
	});
	
});
