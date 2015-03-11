<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="rootURL" value="/"/>
<t:layout>
	<jsp:attribute name="additionalScript">
		<script type="text/javascript" src="${rootURL}resources/js/account/account.js"></script>
		<script type="text/javascript" src="${rootURL}resources/jquery/jquery-ui.js"></script>
	</jsp:attribute>
	<jsp:attribute name="pageTitle">Comptes</jsp:attribute>
	<jsp:body>
		<div class="alert alert-danger hide" role="alert"></div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">
					Comptes
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Imputation</th>
							<th>Date</th>
							<th>Tiers</th>
							<th>Détails</th>
							<th>N° chèque</th>
							<th>Total</th>
							<th>Compte</th>
							<th>Vérifié?</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="entry" items="${entryList.content}">
							<tr>
								<td><c:out value="${entry.accounting.name}"/></td>
								<td><fmt:formatDate pattern="dd/MM/yyyy" value="${entry.date}"/></td>
								<td><c:out value="${entry.thirdParty.name}"/></td>
								<td><c:out value="${entry.detail}"/></td>
								<td><c:out value="${entry.bankCheck.number}"/></td>
								<td><c:out value="${entry.total}"/></td>
								<td><c:out value="${entry.bankAccount.name}"/></td>
								<td class="text-center"><c:if test="${entry.hasBeenChecked == true }"><span class="glyphicon glyphicon-ok green"></span></c:if></td>
							</tr>
						</c:forEach>
						<tr>
							<td>
								<select name="accounting" id="entry_accounting_list">
									<c:forEach var="accounting" items="${accountingList}">
										<option value="${accounting.id}">${accounting.name}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="text" size="6" name="date" id="entry_date"/>
							</td>
							<td>
								<input type="text" size="15" name="third_party" id="entry_third_party" />
							</td>
							<td>
								<input type="text" size="30" name="detail" id="entry_detail"/>
							</td>
							<td>
								<select name="bank_check_number" id="entry_bank_check_number">
									<option value="">--</option>
									<c:forEach var="bankCheck" items="${bankCheckList}">
										<option value="${bankCheck.id}">${bankCheck.number}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="text" size="6" name="total" id="entry_total" />
							</td>
							<td>
								<select name="bank_account" id="entry_bank_account">
									<c:forEach var="bankAccount" items="${bankAccountList}">
										<option value="${bankAccount.id}">${bankAccount.name}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="checkbox" name="has_been_checked" id="entry_has_been_checked"/>
							</td>
						</tr>
						<tr>
							<td colspan="8">
								<button class="btn btn-primary pull-right" onclick="create_entry( '${rootURL}account/addEntry' );">Ajouter</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</jsp:body>
</t:layout>