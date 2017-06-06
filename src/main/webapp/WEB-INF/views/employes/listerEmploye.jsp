<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="./entete.jsp" %>
</head>
<body>



	<h1>Les collaborateurs</h1>

	<!-- Liste des noms -->

	<div class="table-responsive">
		<table class="table">
			<tr>
				<th>Matricule</th>
				<th>Entreprise</th>
				<th>Grade</th>
				<th>Profil Remunération</th>
			</tr>
			<c:forEach var="employe" items="${employes}">
				<tr>
					<td>${employe.matricule}</td>
					<td>${employe.entreprise.denomination}</td>
					<td>${employe.grade.code}</td>
					<td>${employe.profilRemuneration.code}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>

</html>



