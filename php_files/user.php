<?php

$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if(mysqli_connect_errno($con))

{

echo "failed to connect to MYSQL:" .mysqli_connect_error();

}

$name=$_POST['name'];


$pass1=$_POST['pass1'];

$result=mysqli_query($con,"select * from Registration where name='$name' and pass1='$pass1' ");
$row=mysqli_fetch_array($result);
$data=$row[0];

if($data){
echo "yes";
}
else
echo "no";



mysqli_close($con);
?>