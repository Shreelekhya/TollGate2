<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phn = $_POST['phone'];
$new_amt = $_POST['new_amt'];
$result = mysqli_query($con,"update twallet set amount='$new_amt' where phone='$phn' ");


if($result){
echo "Yes";
}
else
echo "No";
mysqli_close($con);
?>