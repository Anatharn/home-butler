<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="rootURL" value="/"/>
<t:layout>
	<jsp:attribute name="additionalScript">
		<script type="text/javascript" src="${rootURL}resources/js/admin/account_management/bank_account_management.js"></script>
		<script type="text/javascript" src="${rootURL}resources/js/admin/account_management/global.js"></script>
	</jsp:attribute>
	<jsp:attribute name="pageTitle">Chèques bancaires</jsp:attribute>
	<jsp:body>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">
					Chèques
				</div>
			</div>
			<div class="panel-body">
				<div class="alert alert-danger hide" role="alert"></div>
				<div class="row">
					<div class="col-xs-6">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>Numéro</th>
									<th>Statut</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bankCheck" items="${bankCheckList}">
									<tr id="bank_check_row_${bankCheck.id}">
										<td><c:out value="${bankCheck.id}" /></td>
										<td><c:out value="${bankCheck.number}" /></td>
										<td>
											<c:choose>
												<c:when test="${bankCheck.isCancelled()}">
													Annulé
												</c:when>
												<c:when test="${bankCheck.isUsed()}">
													Utilisé
												</c:when>
											</c:choose>
										</td>
										<td><input type="submit" class="btn btn-danger" value="Supprimer" onclick="bootbox.confirm('Vous êtes sur le point de supprimer un chèque Voulez-vous continuer?', function( result ){ if( result ){ delete_entity( ${bankCheck.id}, '${rootURL}admin/account_management/del_bank_check', '#bank_check_row_${bankCheck.id}','body > div > div.panel-body > div.alert.alert-danger', 'Une erreur est survenue!' ) } } )"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-xs-4">
						<form:form id="bankCheckForm" name="bankCheckForm" modelAttribute="bankCheckForm"  method="post" action="${rootURL}admin/account_management/add_bank_check" >
																					
							<form:errors path="number" class="label label-danger"/>
							<div class="form-group">
								<label for="number" class="control-label">Numéro:</label>
							   	<form:input type="text" id="number" name="number" path="number" class="form-control" placeholder="Numéro" />
							</div>
							
							<div class="checkbox">
								<label for="cancelled" class="control-label">Annulé
							   		<form:checkbox id="cancelled" name="cancelled" path="cancelled" value="true" />
							   	</label>
							</div>
							
							<div class="form-group">
								<input type="submit" class="btn btn-primary" value="Ajouter"/>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:layout>