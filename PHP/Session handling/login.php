<?php
 if (isset($_POST['utente']))
  {
    //   Connessione al database
	
   $autenticato=1;
   
  if (1)
    {
    // Esiste un record con questi username e password:
    // inserisco i dati nella sessione
    session_start();
    $_SESSION['utente']=$_POST['utente'];
    $_SESSION['password']=$_POST['password'];
	$_SESSION['orario']=time();
    header('location:main.php');
    }
   else header('location:login_failed.php');
  }
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type"><title>Autenticazione</title>
	</head>
	<body>
		<form method="post" action="login.php" name="autenticazione"><br> <!-- Form per l'inserimento delle credenziali -->
			Utente <input name="utente"><br>
			Password <input name="password" type="password"><br><br>
			<input name="Invia" value="Invia" type="submit"><br>
		</form>
	</body>
</html>