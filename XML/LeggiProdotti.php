<?php
	if (file_exists('prodotti.xml')){	//verifica che il file esista
		$xml=simplexml_load_file('prodotti.xml');
		echo "<pre>";
		print_r($xml);	// stampa il file sorgente
		echo"</pre>";
	}
	else{
		exit('Errore nella lettura del file');
	}
	
	// stampa dei contenuti
	echo "<h3>Prodotti nel file prodotti.xml :".count($xml->database->table)."</h3>";
	echo "<ul>";
	echo "<table border='1'><tr><th>IDProdotto</th><th>NomeProdotto</th><th>IDFornitore</th><th>IDCategoria</th><th>QuantitàPerUnità</th><th>PrezzoUnitario</th><th>Scorte</th><th>QuantitàOrdinata</th><th>LivelloDiRiordino</th><th>Sospeso</th></tr>";
	foreach($xml->database->table as $prodotto){
		echo "<tr><td>".$prodotto->column[0]."</td><td>".$prodotto->column[1]."</td><td>".$prodotto->column[2]."</td><td>".$prodotto->column[3]."</td><td>".$prodotto->column[4]."</td><td>".$prodotto->column[5]."</td><td>".$prodotto->column[6]."</td><td>".$prodotto->column[7]."</td><td>".$prodotto->column[8]."</td><td>".$prodotto->column[9]."</td></tr>";
	}
	echo "</table>";
?>