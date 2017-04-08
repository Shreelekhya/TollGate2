<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");
 
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phone = $_POST['phone'];
$result = mysqli_query($con,"select * from tolluser where phone='$phone' ");
$row=mysqli_fetch_array($result);
$r=$row['phone'];
$r1=$row['vn1'];
$r2=$row['vn2'];
$r3=$row['vn3'];
$r4=$row['vn4'];
 
if($result){
echo implode(":",array('Yes',$r,$r1,$r2,$r3,$r4));
}
else
echo "No";
mysqli_close($con);
?>