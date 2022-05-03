<?php
	// connessione al database
	$database="northwind_itdic13";
	$host="127.0.0.1";
	$utente="root";
	$password="";
	$connessione=mysqli_connect($host,$utente,$password,$database) or die ("Connessione non riuscita: ". mysqli_error());
	
	// query -> restituisce alcuni campi dell'ordine specificato nella richiesta
	$IDOrdine=$_POST['IDOrdine'];
	$query=mysqli_query($connessione,"select IDOrdine,DataOrdine,Destinatario,IndirizzoDestinatario,CittaDestinatario,ZonaDestinatario,CAPDestinatario,PaeseDestinatario from ordini where IDOrdine=$IDOrdine") or die ("Query fallita: ". mysqli_error($connessione));

	// stampa tabelle
	echo "<table border=2>";
	
	echo "<tr>";
	for($i=0; $i<mysqli_num_fields($query);$i++){	// stampa i nomi dei campi
	   $property = mysqli_fetch_field($query);
	   echo "<th>".$property->name."</th>";
	}
	echo "</tr>";
	
	while($linea=mysqli_fetch_array($query, MYSQLI_ASSOC)){		// stampa i valori dei campi			
		echo "<tr>";
		foreach ($linea as $valore_colonna) {
			echo "<td>".$valore_colonna."</td>";
		}
		echo "</tr>";
	}
	
	echo "</table>";

	echo "<br/>";
	
	// query -> restituisce alcune informazioni sui prodotti contenuti nell'ordine
	$query=mysqli_query($connessione,"select NomeProdotto as Prodotto,dettagliordini.PrezzoUnitario,Sconto from dettagliordini inner join prodotti on dettagliordini.IDProdotto=prodotti.IDProdotto where IDOrdine=$IDOrdine") or die ("Query fallita: ".mysql_error());
	
	echo "<table border=2>";
	
	echo "<tr>";
	for($i=0; $i<mysqli_num_fields($query);$i++){	// stampa i nomi dei campi
	   $property = mysqli_fetch_field($query);
	   echo "<th>".$property->name."</th>";
	}
	echo "</tr>";
	
	while($linea=mysqli_fetch_array($query, MYSQLI_ASSOC)){ 	// stampa i valori dei campi
		echo "<tr>";
		foreach ($linea as $valore_colonna) {
			echo "<td>".$valore_colonna."</td>";
		}
		echo "</tr>";
	}
	
	echo "</table>";
?> 