<?php
//per il form
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    //codice...
}

// scrivere su file
function writeOnFile($str)
{
    $file = fopen("file.txt", "a");
    if (fwrite($file, $str)) {
        echo "Salvato $str sul file <br>";
    } else {
        echo "Errore di scrittura <br>";
    }
    fclose($file);
}

//leggere da file
function readFromFile()
{
    $file = fopen("file.txt", "r");
    for ($i = 1; !feof($file); $i++) {
        $line = fgets($file);
        $dati = explode(";", $line);
        if (count($dati) != 1) {
            for ($j = 0; $j < count($dati); $j++) {
                echo ($i . " utente) " . $dati[$j] . "<br>");
            }
            echo "-----------------------" . "<br>";
        }
    }

    fclose($file);
}

function login(){

    session_start();

    if(isset($_SESSION["userId"])){
        header("Location: welcome.php");
    }

    if(!empty($_POST["email"]) && !empty($_POST["password"])){
        if(($_POST["email"] == "email") && ($_POST["password"] == "password")){
            $_SESSION["userId"] = $_POST["email"];
            header("Location: welcome.php");
        }
        else{
            header("Location: index.html");
        }
    }
}

function welcomePage(){
    session_start();

    if(!isset($_SESSION["userId"])){
        header("Location:index.html");
        exit;
    }else{
        echo "Benvenuto utente: " . $_SESSION["userId"];
    }
}

function ricercaDaFile(){
    $file = fopen("file.txt", "r");
    for ($i = 1; !feof($file); $i++) {
        $line = fgets($file);
        $dati = explode(";", $line);
        // ricerca per nome ecc...
        if ($dati[0] == $_POST["rnome"]) {
            echo $dati[0] . " " . $dati[1] . " " . $dati[2] . " " . $dati[3] . " " . $dati[4] . " " . $dati[5];
        }
    }

    fclose($file);
}

function creaTabella($header, $file, $separator)
{
    echo '<style type="text/css">
    table, th, td {
        border: 1px solid black;
      }
      table {
        border-collapse: collapse;
      }
      </style>';
    echo '<table><tr>';
    for ($i = 0; $i < count($header); $i++) {
        echo '<th>' . $header[$i] . '</th>';
    }
    echo '</tr>';
    for ($j = 1; !feof($file); $j++) {
        $line = fgets($file);
        $dati = explode($separator, $line);
        if (count($dati) != 1) {
            echo '<tr>';
            for ($i = 0; $i < count($dati); $i++) {
				// fare if per sesso colorato o altre robe
				
                //if (trim($dati[$i]) == "M") {
                    //echo '<td> <div style="width: 15px;height: 15px; margin: auto; background: lightblue"></div> </td>';
                //} else if (trim($dati[$i]) == "F") {
                    //echo '<td> <div style="width: 15px;height: 15px; margin: auto; background: pink"></div> </td>';
                //} else {
                    echo '<td>' . $dati[$i] . '</td>';
				//}
            }
            echo '</tr>';
        }
    }
    echo '</table>';
}

function EliminazioneRandomSuFile(){

$max = 0;
if ($file = fopen("file.txt", "r")) {
    for ($i = 0; !feof($file); $i++) {
        $line = fgets($file);
        $split = explode(";", $line);
        if (count($split) != 1) {
            $max = $max + 1;
        }
    }
    fclose($file);
}
$n = rand(0, $max - 1);
$a = "";
if ($file = fopen("file.txt", "r")) {
    for ($i = 0; !feof($file); $i++) {
        $line = fgets($file);
        if ($i != $n) {
            $a = $a . $line;
        }
    }
    fclose($file);
}
$file = fopen("file.txt", "w");
fwrite($file, $a);
fclose($file);
}

function ModificaSuFile(){
	// se é come la preverifica bisogna passare anche la email ricercata 
	// con <input type="hidden" value="'.$_POST["ricercaEmail"].'" name="ricercaEmail"/>
	str = "";
    $file = fopen("file.txt", "r");
    for ($i = 1; !feof($file); $i++) {
        $line = fgets($file);
        $dati = explode(";", $line);
        echo $_POST["ricercaEmail"];
        echo $dati[2];
        if ($dati[2] == $_POST["ricercaEmail"]) {
            $dati[0] = $_POST["nuovoNome"];
            $dati[1] = $_POST["nuovoCognome"];
        }
        $str .= $dati[0] . ";" . $dati[1] . ";" . $dati[2] . ";". $dati[3] . "|||";
    }
    fclose($file);

    $file = fopen("file.txt", "w");
    if (fwrite($file, $str)) {
        echo $str;
    } else {
        echo "Errore di scrittura <br>";
    }
    fclose($file);
}
}

function cookie(){
    
    setcookie("utente", $_POST['nome'].";".$_POST['email'], time() + (86400 * 30), "/"); 
    header("location: index.php");
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- form -->
    <form action="login.php" method="POST">
        <h2>Login Form</h2>
        <input type="text" name="email" placeholder="Insert your email..."><br>
        <input type="text" name="password" placeholder="Insert your password..."><br>
        <button type="submit">CONFERMA</button>
    </form>
</body>
</html>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- cookie html -->
    <form action="cookie.php" method="post">
        <label for="">Nome: </label><input type="text" name="nome" id="" /><br />
        <label for="">Email: </label><input type="text" name="email" id="" /><br />
        <input type="submit" />
    </form>

    <?php
    if (!isset($_COOKIE["utente"])) {
        echo "Nessun cookie";
    } else {
        echo "Bentornato " . explode(";",$_COOKIE["utente"])[0];
    }
    ?>
</body>
</html>