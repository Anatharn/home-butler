
function get_accounting_list( rank, rootUrl ){
	$("#accountingList > table > tbody").empty();
	$.post( rootUrl + "../../rest/admin/account_management/accountingList", "rank=" + rank , function( data ) {
		var tbody = $("#accountingList > table > tbody");
		var html = '';
		for( var i = 0; i < data.content.length; i++ ){
			var accounting = data.content[i];
			html +='<tr id="accounting_row_' + accounting.id + '">'+
						'<td>' + accounting.id +'</td>' + 
						'<td>' + accounting.name + '</td>' + 
						'<td>' + 
							'<input type="submit" class="btn btn-danger" value="Supprimer" onclick="bootbox.confirm(' +
								'\'Vous êtes sur le point de supprimer un type de compte. Voulez-vous continuer?\',' + 
								'function( result ){' + 
									'if( result ){' + 
										'delete_entity( ' + accounting.id + ', ' + 
														'\'' + rootUrl + 'del_accounting\', ' + 
														'\'#accounting_row_' +accounting.id + '\', ' + 
														'\'body > div.alert.alert-danger\', ' + 
														'\'Une erreur est survenue!\' ' +
													')' + 
									'}' + 
								'}' + 
							')" '+ 
							'/>'+
						'</td>'+
					'</tr>';
		}
		tbody.html( html );
	}, "json");
}