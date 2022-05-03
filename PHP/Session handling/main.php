<?php
session_start();
if (!isset($_SESSION['utente']))
    {
	  header('location:login_failed.php');
	  exit;
	}
else
{
	// visualizza le informazioni di sessione
	echo "<b>Pagina principale del sito<b> <br><br>";
	echo "Identificatore di sessione:  ".session_id()."<br>";
	echo "Benvenuto  ".$_SESSION['utente']."<br>";
	echo "La tua password:  ".$_SESSION['password']."<br>";
	echo "Data e ora attuale:  ".date('d m Y H:i:s')."<br>";
	echo "Hai fatto il login alle  ".date('d m Y H:i:s',$_SESSION['orario'])."<br>";
  
  
  
}

?>
<A HREF="logout.php"> Termina sessione </A>