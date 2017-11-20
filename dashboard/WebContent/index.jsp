<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" context="text/html; charset=ISO-8859-1" />
<meta name="google-signin-scope" content="profile email" />
<meta name="google-signin-client_id"
	content="457361457756-8q8qktue282r6ch6ue6pc6qn2rdssedg.apps.googleusercontent.com" />

<link rel='stylesheet' href='resources\css\login_google.css' />
<link rel='stylesheet' href='resources\css\normalize.css' />
<link rel='stylesheet' href='resources\css\styles.css' />
<link rel='stylesheet' href='resources\css\bootstrap.css' />
<link
	href="https://fonts.googleapis.com/css?family=Libre+Barcode+128+Text"
	rel="stylesheet">
<script src='resources\js\bootstrap.js'></script>
<script src='resources\js\jquery-3.2.1.js'></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>

<title>Dashboard - Tasks</title>

</head>

<body>
	<div class="jumbotron text-center">
		<header>
			<div id="cab_logo">
				<img src='resources/imagens/logo.png' />
				<h1>DashBoard - Tasks</h1>
			</div>
		</header>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="user">
					<img id="user-photo" src="resources/imagens/user-anonimo.jpg" />
					<h1>
						Olá, <span id="user-name">visitante</span>!
					</h1>
					<p id="user-email"></p>
				</div>
				<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"
					data-width="370" data-height="50" data-longtitle="true"
					data-lang="pt-BR"></div>
			</div>
		</div>
	</div>
	<script>
		function onSignIn(googleUser) {
			var profile = googleUser.getBasicProfile();
			console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
			console.log('Name: ' + profile.getName());
			console.log('Image URL: ' + profile.getImageUrl());
			console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

			var redirectUrl = 'login';

			//using jquery to post data dynamically
			var form = $('<form action="' + redirectUrl + '" method="post">'
					+ '<input type="text" name="id_token" value="'
					+ googleUser.getAuthResponse().id_token + '" />'
					+ '</form>');
			$('body').append(form);
			form.submit();
		};
	</script>

	<hr />

	<footer>Copyright @ 2017 - Todos os direitos reservados.
		Produzido por Camila</footer>
</body>
</html>