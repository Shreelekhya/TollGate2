<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");
 
if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phone = $_POST['phone'];
$name = $_POST['name'];
$email = $_POST['email'];
$phone2 = $_POST['phone2'];
$passw=$_POST['password'];

$street=$_POST['street'];
$district=$_POST['district'];
$state=$_POST['state'];
$country=$_POST['country'];
$tuser=$_POST['tuser'];
$nofvehicles=$_POST['nofvehicles'];
$vt1=$_POST['vt1'];
$vn1=$_POST['vn1'];
$vt2=$_POST['vt2'];
$vn2=$_POST['vn2'];
$vt3=$_POST['vt3'];
$vn3=$_POST['vn3'];
$vt4=$_POST['vt4'];
$vn4=$_POST['vn4'];

$result = mysqli_query($con,"update tolluser set name='$name',email='$email',password='$passw',phone='$phone2',street='$street',district='$district',state='$state',country='$country',tuser='$tuser',nofvehicles='$nofvehicles',vt1='$vt1',vn1='$vn1',vt2='$vt2',vn2='$vn2',vt3='$vt3',vn3='$vn3',vt4='$vt4',vn4='$vn4' where phone='$phone'");

if($result){
echo "Yes";
}
else
echo "No";
mysqli_close($con);
?>