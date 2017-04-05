<?php
   $con=mysql_connect($servername, $username, $password, $db_name);

   if (mysqli_connect_errno($con)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }
	
   $username = $_POST['contactnumber'];
   $password = $_POST['password'];
   $result = mysqli_query($con,"SELECT contactnumber FROM logintable where 
   contactnumber='$username' and Password='$password'");
   $row = mysqli_fetch_array($result);
   $data = $row[0];

   if($data){
      echo $data;
   }
	
   mysqli_close($con);
?>