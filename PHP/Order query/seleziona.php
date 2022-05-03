<?php
	// Connessione al database
	$database="northwind_itdic13";
	$host="127.0.0.1";
	$utente="root";
	$password="";
	$connessione=mysqli_connect($host,$utente,$password,$database) or die ("Connessione non riuscita: ". mysqli_error());
	
	// query -> restituisce gli ID di tutti gli ordini
	$query=mysqli_query($connessione,"select IDOrdine from ordini order by IDOrdine asc") or die ("Query fallita: ". mysqli_error($connessione));
?>
<html>
	<head>
		<title>Visualizza Dettagli Ordine</title>
	</head>
	<body>
		IDOrdine
		<select name="IDOrdine" id="ID" >
			<?php
				for($i = 0; $i < mysqli_num_rows($query); $i++)		// stampa tutti gli ID nel menu a cascata
				{     
					echo "<option>".mysqli_fetch_row($query)[0]."</option>";
				}
			?>
		</select>
		<button onclick="loadDoc()">Ottieni Informazioni</button>
		<div id="order"></div>
		
		<script>
			function loadDoc() {
				var xhttp = new XMLHttpRequest();		// crea l'oggetto XMLHttpRequest
				
				xhttp.onreadystatechange = function() {			// ogni volta che lo stato della richiesta cambia...
					if (this.readyState == 4 && this.status == 200) {    	// se la richiesta è andata a buon fine e la risposta è pronta...
						document.getElementById("order").innerHTML = xhttp.responseText;		// visualizza la risposta del server
					}
				};
				
				// imposta la richiesta da inviare al server
				xhttp.open("POST","visualizza.php",true);																			
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				var idOrdine=document.getElementById('ID').options[document.getElementById('ID').selectedIndex].value;
				
				xhttp.send("IDOrdine="+idOrdine);		//invia la richiesta al server
			}
		</script>
	</body>
</html>