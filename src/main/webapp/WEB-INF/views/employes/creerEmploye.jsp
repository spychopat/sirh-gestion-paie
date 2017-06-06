<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../entete.jsp" %>
</head>
<form class="form-horizontal" method="post">
	<fieldset>
		<h1>Ajouter Un Employé</h1>
		<!-- matricule-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Matricule</label>
			<div class="col-md-4">
				<input id="matricule" name="matricule" type="text" placeholder=""
					class="form-control input-md">
			</div>
		</div>
		<!-- entreprise -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Entreprise</label>
			<div class="col-md-4">
				<select id=entreprise name="entreprise" class="form-control">
					<c:forEach var="entreprise" items="${entreprise}">
						<option value="${entreprise.id}">${entreprise.denomination}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<!-- profil -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Profil</label>
			<div class="col-md-4">
				<select id="profil" name="profil" class="form-control">
					<c:forEach var="profil" items="${profil}">
						<option value="${profil.id}">${profil.code}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- grade -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Grade</label>
			<div class="col-md-4">
				<select id="grade" name="grade" class="form-control">
					<c:forEach var="grade" items="${grade}">
						<option value="${grade.id}">${grade.code}</option>
					</c:forEach>
				</select>
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





