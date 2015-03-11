<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<%@include file="taglib.jsp" %>

<c:url var="rootURL" value="/"/>

<html>
	<head>
		<title>Administrator</title>
		<link href="${rootURL}resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${rootURL}resources/css/styles.css" />
		<script type="text/javascript" src="${rootURL}resources/jquery/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="${rootURL}resources/js/app.js"></script>
		<script type="text/javascript" src="${rootURL}resources/bootstrap/js/bootstrap.js"></script>
	</head>
	<body>
		<div class="col-md-6 col-md-offset-2">	
			<c:if test="${param.error != null}">
	             <div class="alert alert-danger">
	                 Invalid UserName and Password.
	             </div>
	         </c:if>
	         <c:if test="${param.logout != null}">
	             <div class="alert alert-success">
	                 You have been logged out.
	             </div>
	         </c:if>	
	     </div>  
            
	     <div class="container">
			<form:form id="loginForm" method="post" action="${rootURL}login" modelAttribute="user" cssClass="form-signin" role="form" >
				<h2 class="form-signin-heading">Home Butler</h2>
				<input type="text" id="username" name="username" class="form-control" placeholder="UserName" />
		      	<input type="password" id="password" name="password" class="form-control" placeholder="Password" />
		    	<input type="submit" class="btn btn-lg btn-primary btn-block" value="Login">
			</form:form>
		</div>
	</body>
</html>

