<?php
	
	$servername = "localhost";
	$username = "root";
	$password = "";
	$my_db = "hifazat";
	
	$conn = mysqli_connect($servername, $username, $password, $my_db); 
	
	$connum=$_POST["number"];
	$password=_POST["password"];
	
	$abc = mysqli_prepare($conn, "SELECT * FROM logintable WHERE number = ? AND password = ?"); //select data from mysql. 
	mysqli_stmt_bind_param($abc, "ss", $connum, $password);
	mysqli_stmt_execute($abc);
	
	mysqli_stmt_store_result($abc);
	mysql_stmt_bind_result($abc, $name, $phonum, $password, $email_id, $homeadd);
	
	$response = array();
	$response["success"] = false;
	
	while(mysqli_stmt_fetch($abc)){
		$response["success"] = true;
		$response["name"] = $name;
		$response["contactnumber"] = $phonum;
		$response["password"] = $password;
		$response["emailid"] = $email_id;
		$response["homeaddress"] = $homeadd;
	}
	
	echo json_encode($response);
		
	
	

?>