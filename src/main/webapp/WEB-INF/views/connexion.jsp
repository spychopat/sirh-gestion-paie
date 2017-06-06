<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<link rel="icon" type="image/png" href="http://files.gamebanana.com/img/ico/sprays/516c32f08e03d.png" />
	
</head>
<body class="container">
	<h1>Connexion</h1>
	<!-- Spring Security s'attend aux paramètres "username" et "password" -->
	<form method="post">
		<input name="username"> 
		<input name="password"> 
		<input type="submit" value="Se connecter">
		<sec:csrfInput/>
	</form>
	<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
	<c:if test="${param.error !=null}">
Erreur d'authentification
</c:if>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<img src="http://files.gamebanana.com/img/ico/sprays/516c32f08e03d.png">

</body>
</html>