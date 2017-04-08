<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phone = $_POST['phone'];
$passw = $_POST['password'];
$result = mysqli_query($con,"select * from tolluser where phone='$phone' and password='$passw' ");
$row=mysqli_fetch_array($result);
$r=$row['phone'];
$r1=$row['tuser'];
$r2=$row['vt1'];
$r3=$row['vt2'];
$r4=$row['vt3'];
$r5=$row['vt4'];

if($result){
echo implode(":",array('Yes',$r,$r1,$r2,$r3,$r3,$r5));
}
else
echo "No";
mysqli_close($con);
?>
