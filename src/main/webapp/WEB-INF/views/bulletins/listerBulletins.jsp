<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../entete.jsp"%>
</head>
<body>
	<h1>Liste des bulletins</h1>
	<table class="table">
		<tr>
			<th>Date/heure creation</th>
			<th>Periode</th>
			<th>Matricule</th>
			<th>Salaire Brut</th>
			<th>Net Imposable</th>
			<th>Net à payer</th>
		</tr>
		<c:forEach var="bulletins" items="${bulletins}">
			<tr>
				<td>${bulletins.dateForm()}</td>
				<td>${bulletins.periode.dateDebut} - ${bulletins.periode.dateFin}</td>
				<td>${bulletins.remunerationEmploye.matricule}</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>
