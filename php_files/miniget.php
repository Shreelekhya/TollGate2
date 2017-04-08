<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");
 
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phone = $_POST['phone'];
$result = mysqli_query($con,"select * from tolluser where phone='$phone' ");
$row=mysqli_fetch_array($result);
$data=$row[0];
$nofvehicles=$row['nofvehicles'];
$tuser=$row['tuser'];
$vt1=$row['vt1'];
$vt2=$row['vt2'];
$vt3=$row['vt3'];
$vt4=$row['vt4'];
if($data){
echo implode(" ",array('Yes',$tuser,$nofvehicles,$vt1,$vt2,$vt3,$vt4));
}
else
echo "No";
mysqli_close($con);
?>