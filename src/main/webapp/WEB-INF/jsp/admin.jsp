<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Administrator</title>
<link rel="stylesheet" href='<spring:url value="resources/css/styles.css"/>' />
<script type="text/javascript" src='<spring:url value="resources/jquery/jquery-1.10.2.js"/>'></script>
<script type="text/javascript" src='<spring:url value="resources/js/app.js"/>'></script>
<script type="text/javascript">

</script>
</head>
<body>
	<h2>Administrator Home Page</h2>
	<p> <a href="${rootUrl}admin/account_management/account_data_management">account data</a>
	<p> <a href="${rootUrl}admin/account_management/bank_account_management">bank account</a>
	<p>	<a href="${rootURL}welcome">Home</a></p>
	<p>	<a href="${rootURL}logout">Logout</a></p>
	
</body>
</html>