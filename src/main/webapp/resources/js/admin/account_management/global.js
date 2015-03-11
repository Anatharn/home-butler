/**
 * 
 */
function delete_entity( id, url, toRemove, divError, errorMessage ){ 
	$.post( url, 
			{ id : id } )
	.error( function()
			{ 
				$(divError)
				.text( errorMessage )
				.removeClass( 'hide' ) 
			} )
	.success( function()
			{ 
				$( toRemove ).remove() 
			} );
}