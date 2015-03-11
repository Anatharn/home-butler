/**
 * 
 */
function create_entry( url ){
	jQuery.ajax({
	    headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
	    'type': 'POST',
	    'url': url,
	    'data': JSON.stringify( {
			accounting : $('#entry_accounting_list option:selected').val(),
			date : $('#entry_date').val(),
			third_party : $('#entry_third_party').val(),
			detail : $('#entry_detail').val(),
			bank_check_number_id : $('#entry_bank_check_number option:selected').val(),
			total : $('#entry_total').val(),
			bank_account : $('#entry_bank_account').val(),
			has_been_checked : $('#entry_has_been_checked').prop( 'checked' )
		}),
	    'dataType': 'json',
	    'success':  function (data){ 
			console.log( data ) 
		}
	});
}
$(function() {
	   
    $( "#entry_third_party" ).autocomplete({
    	source : function (request, response ){
    		jQuery.ajax({
    	    	headers: { 
	    	        'Accept': 'application/json',
	    	        'Content-Type': 'application/json' 
	    	    },
	    	    'type': 'POST',
	    	    'url': '/home-butler/account/autoCompleteThirdparty',
	    	    'data': JSON.stringify( request ),
	    	    'dataType': 'json',
	    	    'success':  function (data){ 
	    	    	response( data );
	    		}
    		})
    	},
    	minLength : 2
  	});
})