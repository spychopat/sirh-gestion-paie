<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../entete.jsp" %>
</head>
<body>



	<h1>Bulletins de salaire</h1>

	<!-- Liste des noms -->

	<div class="table-responsive">
		<table class="table">
			<tr>
				<th>Date création</th>
				<th>Période</th>
				<th>Matricule</th>
				<th>Salaire brut</th>
				<th>Net imposable</th>
				<th>Net à payer</th>
			</tr>
			<c:forEach var="bulletin" items="${bulletins}">
				<tr>
				<!--  TODO
					<td>${bulletin.matricule}</td>
					-->
				</tr>
			</c:forEach>
		</table>
	</div>

</body>

</html>



