<?php 
session_start();
if (!isset($_SESSION['utente']))
    {
	  header('location:login_failed.php');
	  exit;
	}
else
{
   // termina nessione
   $_SESSION = array(); // svuota l'array delle variabili di sessione
   session_destroy(); // distrugge la sessione corrente
   header('location:login.php');
}
?>