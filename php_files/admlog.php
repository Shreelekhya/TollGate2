<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phone = $_POST['phone'];
$passw = $_POST['password'];
$result = mysqli_query($con,"select * from admin where id='$phone' and password='$passw' ");
$row=mysqli_fetch_array($result);
$r=$row['id'];
$r1=$row['location'];
if($result){
echo implode(":",array('Yes',$r,$r1));
}
else
echo "No";
mysqli_close($con);
?>
