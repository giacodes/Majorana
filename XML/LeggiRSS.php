<?php
	if ($xml=simplexml_load_file('http://www.ansa.it/sito/ansait_rss.xml')){ // verifica collegamento
		echo "<pre>";
		print_r($xml); // stampa file sorgente
		echo"</pre>";
	}
	else	exit('Errore nella lettura del file');
	
	// stampa dei contenuti
	echo "<h3>Articoli nel file ansait_rss.xml :".count($xml->channel->item)."</h3>";
	echo "<ul>";
	echo "<table border='1'><tr><th>Titolo</th><th>Descrizione</th><th>Link</th><th>Data di pubblicazione</th></tr>";
	foreach($xml->channel->item as $articolo){
		echo "<tr><td>".$articolo->title."</td><td>".$articolo->description."</td><td><a href='".$articolo->link."'>Pagina articolo</a></td><td>".$articolo->pubDate."</td></tr>";
	}
	echo "</table>";
?>