<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");
 
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phone = $_POST['phone'];
$f = $_POST['f'];
$t=$_POST['t'];
$result = mysqli_query($con,"insert into Book (phone,f,t) values('$phone','$f','$t')");

 
if($result){
echo "yeah";
}
else
echo "nnno";
mysqli_close($con);
?>
 