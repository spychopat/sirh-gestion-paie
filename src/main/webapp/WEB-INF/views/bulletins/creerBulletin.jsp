<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../entete.jsp" %>
</head>
<form class="form-horizontal" method="post">
	<fieldset>
		<h1>Créer Bulletin Salaire</h1>
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Periode</label>
			<div class="col-md-4">
				<select id=periode name="periode" class="form-control">
					<c:forEach var="periode" items="${periode}">
						<option value="${periode.id}">${periode.dateDebut} - ${periode.dateFin}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Matricule</label>
			<div class="col-md-4">
				<select id="matricule" name="matricule" class="form-control">
					<c:forEach var="employe" items="${employe}">
						<option value="${employe.id}">${employe.matricule}</option>
					</c:forEach>
				</select>
			</div>
		</div>



		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Prime</label>
			<div class="col-md-4">
				<input id="prime" name="prime" type="text" placeholder=""
					class="form-control input-md">
			</div>
		</div>



		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-4">
				<button id="singlebutton" name="name" class="btn btn-primary">Ajouter</button>
			</div>
		</div>
	</fieldset>
</form>
</body>
</html>





