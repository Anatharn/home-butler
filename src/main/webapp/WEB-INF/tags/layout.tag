<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="pageTitle" fragment="true" %>
<%@ attribute name="additionalScript" fragment="true"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:url var="rootURL" value="/"/>

<html>
	<head>
		<title>Alfred the Home Butler</title>
		<link href="${rootURL}resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
		<link href="${rootURL}resources/css/styles.css" media="screen" rel="stylesheet" type="text/css" />
		<link href="${rootURL}resources/jquery/css/jquery-ui.css" media="screen" rel="stylesheet" type="text/css" />		
		<script type="text/javascript" src="${rootURL}resources/jquery/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="${rootURL}resources/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript" src="${rootURL}resources/bootstrap/js/bootbox.js"></script>
		<jsp:invoke fragment="additionalScript"></jsp:invoke>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<ul class="nav navbar-nav">
						<li class="dropdown">
	          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Comptes <span class="caret"></span></a>
	          				<ul class="dropdown-menu" role="menu">
	            				<li><a href="/home-butler/account/account">Comptes</a></li>
	            				<li class="divider"></li>
	            				<li><a href="/home-butler/admin/account_management/bank_account_management">Gestion des comptes</a></li>
	            				<li><a href="/home-butler/admin/account_management/bank_check_management">Gestion des chèques</a></li>
	            				<li><a href="/home-butler/admin/account_management/account_data_management">Gestion des données de compte</a></li>
	          				</ul>
	        			</li>
	        		</ul>
				</div>
				<div>
				</div>
			</div>
		</nav>
		<div class="page-header">
			<h1>
				<jsp:invoke fragment="pageTitle"></jsp:invoke>
			</h1>
		</div>
		<jsp:doBody /> 
	</body>
</html>