<?php
	
	$servername = "localhost";
	$username = "root";
	$password = "";
	$my_db = "hifazat";
	
	$conn = mysqli_connect($servername, $username, $password, $my_db);
	
	$name = $_POST["name"];
	$phonum = $_POST["contactNumber"];
	$password = $_POST["password"];
	$email_id = $_POST["emailid"];
	$homeadd = $_POST["homeaddress"];
	
	$abc = mysqli_prepare($conn, "INSERT INTO signup (name, contactNumber, password, emailid, homeaddress) VALUES (?, ?, ?, ?, ?)");
	mysqli_stmt_bind_param($abc, "siss", $name, $phonum, $password, $email_id, $homeadd);
	mysqli_stmt_execute($abc);
	
	$response = array();
	$response["success"] = true;
	
	echo json_encode($response);
	
?>