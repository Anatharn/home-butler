<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="rootURL" value="/"/>
<t:layout>
	<jsp:attribute name="additionalScript">
		<script type="text/javascript" src="${rootURL}resources/js/admin/account_management/bank_account_management.js"></script>
	</jsp:attribute>
	<jsp:attribute name="pageTitle">Account management</jsp:attribute>
	<jsp:body>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">
					Comptes
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
									<th>Nom</th>
									<th>Numéro</th>
									<th>IBAN</th>
									<th>Type</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bankAccount" items="${bankAccountList}">
									<tr id="bank_account_row_${bankAccount.id}">
										<td><c:out value="${bankAccount.id}" /></td>
										<td><c:out value="${bankAccount.name}" /></td>
										<td><c:out value="${bankAccount.number}"/></td>
										<td><c:out value="${bankAccount.iban}"/></td>
										<td><c:out value="${bankAccount.accountType.name}"/></td>
										<td><input type="submit" class="btn btn-danger" value="Supprimer" onclick="bootbox.confirm('Vous êtes sur le point de supprimer un compte. Voulez-vous continuer?', function( result ){ if( result ){ delete_entity( ${bankAccount.id}, '${rootURL}admin/account_management/del_bank_account', '#bank_account_row_${bankAccount.id}','body > div > div.panel-body > div.alert.alert-danger', 'Une erreur est survenue!' ) } } )"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-xs-4">
						<form:form id="bankAccountForm" name="bankAccountForm" modelAttribute="bankAccountForm"  method="post" action="${rootURL}admin/account_management/add_bank_account" >
							<form:errors path="name" class="label label-danger"/>
							<div class="form-group">
								<label for="name" class="control-label">Nom:</label>
							   	<form:input type="text" id="name" name="name" path="name" class="form-control" placeholder="Nom" />
							</div>
														
							<form:errors path="number" class="label label-danger"/>
							<div class="form-group">
								<label for="number" class="control-label">Numéro:</label>
							   	<form:input type="text" id="number" name="number" path="number" class="form-control" placeholder="Numéro" />
							</div>
														
							<form:errors path="iban" class="label label-danger"/>
							<div class="form-group">
								<label for="iban" class="control-label">IBAN:</label>
							   	<form:input type="text" id="iban" name="iban" path="iban" class="form-control" placeholder="IBAN" />
							</div>
														
							<form:errors path="type" class="label label-danger"/>
							<div class="form-group">
								<label for="accountType" class="control-label">Type de compte:</label>
								<form:select path="type"  class="form-control">
    								<form:options items="${accountTypeList}" />
								</form:select>
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