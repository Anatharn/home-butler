<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="rootURL" value="/"/>

<t:layout>
	<jsp:attribute name="pageTitle">Welcome</jsp:attribute>
	<jsp:body>
		<h3>Email: <sec:authentication property="name"/></h3>
		<h3>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="${rootUrl}admin">Administration</a>
			</sec:authorize>
		</h3>
		<p>	<a href="${rootUrl}logout">Logout</a></p>
	</jsp:body>
</t:layout>
