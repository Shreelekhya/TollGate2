<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");
 
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phone = $_POST['phone'];
$result = mysqli_query($con,"select * from tolluser where phone='$phone' ");
$row=mysqli_fetch_array($result);
$name = $row['name'];
$email = $row['email'];
$phn=$row['phone'];
$passw= $row['password'];
$street = $row['street'];
$district = $row['district'];
$state = $row['state'];
$country = $row['country'];
$tuser = $row['tuser'];
$nofvehicles = $row['nofvehicles'];
$vt1 = $row['vt1'];
$vn1 = $row['vn1'];
$vt2 = $row['vt2'];
$vn2 = $row['vn2'];
$vt3 = $row['vt3'];
$vn3 = $row['vn3'];
$vt4 = $row['vt4'];
$vn4 = $row['vn4'];
if($name)
echo implode(":",array($name,$email,$phn,$passw,$street,$district,$state,$country,$tuser,$nofvehicles,$vt1,$vn1,$vt2,$vn2,$vt3,$vn3,$vt4,$vn4));
else
echo "No";
mysqli_close($con);
?>
