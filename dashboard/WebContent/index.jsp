<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" context="text/html; charset=ISO-8859-1"/>
	<meta name="google-signin-scope" content="profile email"/>
    <meta name="google-signin-client_id" content="457361457756-8q8qktue282r6ch6ue6pc6qn2rdssedg.apps.googleusercontent.com"/>
    
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    
    <link rel='stylesheet' href='resources\css\normalize.css'/>
	<link rel='stylesheet' href='resources\css\login_google.css'/>
	<title>Dashboard - Tasks</title>
	
</head>

<body>
	<h1>Seja bem vindo ao sistema DashBoard - Tasks</h1>

    <div class="user">
      <img id="user-photo" src="resources/imagens/user-anonimo.jpg"/>
      <h1>Olá, <span id="user-name">visitante</span>!</h1>
      <p id="user-email"></p>
    </div>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" data-width="370" data-height="50" data-longtitle="true" data-lang="pt-BR"></div>
 	
    <script>
    function onSignIn(googleUser) {
    	  var profile = googleUser.getBasicProfile();
    	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    	  console.log('Name: ' + profile.getName());
    	  console.log('Image URL: ' + profile.getImageUrl());
    	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    	  
    	  var redirectUrl = 'login';
    	  
          //using jquery to post data dynamically
          var form = $('<form action="' + redirectUrl + '" method="post">' +
                           '<input type="text" name="id_token" value="' +
                            googleUser.getAuthResponse().id_token + '" />' +
                                                                 '</form>');
          $('body').append(form);
          form.submit();
    	};
    	
    </script>

	<hr />

</body>
</html>