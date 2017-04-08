<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$phone = $_POST['phone'];
$cardnumber = $_POST['cardnumber'];
$amount=$_POST['amount'];
$result = mysqli_query($con,"insert into twallet (phone,cardnumber,amount) values('$phone','$cardnumber','$amount')");
if($result){
echo "Yes";
}
else
echo "No";
mysqli_close($con);
?>
