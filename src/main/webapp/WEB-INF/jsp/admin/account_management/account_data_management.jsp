<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="rootURL" value="/"/>
<t:layout>
	<jsp:attribute name="additionalScript">
		<script type="text/javascript" src="${rootURL}resources/js/admin/account_management/account_data_management.js"></script>
		<script type="text/javascript" src="${rootURL}resources/js/admin/account_management/global.js"></script>
	</jsp:attribute>
	<jsp:attribute name="pageTitle">Account Data management</jsp:attribute>
	<jsp:body>
		<div class="alert alert-danger hide" role="alert"></div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">
					Type de compte
				</div>
			</div>
			<div class="panel-body">		
				<div class="row">
					<div class="col-xs-6">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>name</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="type" items="${accountTypes}">
									<tr id="account_type_row_${type.id}">
										<td><c:out value="${type.id}" /></td>
										<td><c:out value="${type.name}" /></td>
										<td><input type="submit" class="btn btn-danger" value="Supprimer" onclick="bootbox.confirm('Vous êtes sur le point de supprimer un type de compte. Voulez-vous continuer?', function( result ){ if( result ){ delete_entity( ${type.id}, '${rootURL}admin/account_management/del_account_type', '#account_type_row_${type.id}','body > div.alert.alert-danger', 'Une erreur est survenue!' ) } } )"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-xs-4">
						<form:form id="accountTypeForm" name="accountTypeForm" modelAttribute="accountTypeForm"  method="post" action="${rootURL}admin/account_management/add_account_type" >
							<form:errors path="name" class="label label-danger"/>
							<div class="form-group">
								<label for="accountType" class="control-label">type de compte:</label>
							   	<form:input type="text" id="accountType" name="accountType" path="name" class="form-control" placeholder="Type de compte" />
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-primary" value="Ajouter"/>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">
					Imputations
				</div>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-xs-6" id="accountingList">
						<c:forEach var="i" begin="0" end="${accountingList.totalPages - 1}">
							<button type="button" class="btn btn-link" onClick="get_accounting_list(${i} , '${rootUrl}');"><c:out value="${i}"/></button>
						</c:forEach>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>name</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="accounting" items="${accountingList.content}">
									<tr id="accounting_row_${accounting.id}">
										<td><c:out value="${accounting.id}" /></td>
										<td><c:out value="${accounting.name}" /></td>
										<td><input type="submit" class="btn btn-danger" value="Supprimer" onclick="bootbox.confirm('Vous êtes sur le point de supprimer un type de compte. Voulez-vous continuer?', function( result ){ if( result ){ delete_entity( ${accounting.id}, '${rootURL}admin/account_management/del_accounting', '#accounting_row_${accounting.id}','body > div.alert.alert-danger', 'Une erreur est survenue!' ) } } )"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-xs-4">
						<form:form id="accountingForm" name="accountingForm" modelAttribute="accountingForm"  method="post" action="${rootURL}admin/account_management/add_accounting" >
							<form:errors path="name" class="label label-danger"/>
							<div class="form-group">
								<label for="accountType" class="control-label">Imputation:</label>
							   	<form:input type="text" id="accounting" name="accounting" path="name" class="form-control" placeholder="Imputation" />
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-primary" value="Ajouter"/>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">window.onload = get_accounting_list(0 , '${rootUrl}');</script>
	</jsp:body>
</t:layout>