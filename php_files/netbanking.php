<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$uname = $_POST['uname'];
$passw = $_POST['lpass'];
$result = mysqli_query($con,"select * from netbanking where name='$uname' and lpass='$passw' ");
$row=mysqli_fetch_array($result);
$data=$row[0];
if($data){
echo "Yes";
}
else
echo "No";
mysqli_close($con);
?>
