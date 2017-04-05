<?php

$servername = "localhost";
$username = "root";
$password = "";
$db_name="androiddb";

$con=mysql_connect($servername, $username, $password, $db_name);

if(!$con)
{
 die("Connection Failed:".mysql_connect_error())
}

$sql="INSERT INTO logintable (contactnumber, password) VALUES ('03238231956','znrzz12345')";

if (mysqli_query($con,$sql)) {
      echo "Values have been inserted successfully";


?>