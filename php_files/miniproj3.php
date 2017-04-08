<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$creditcardno = $_POST['creditcardno'];
$cvv = $_POST['cvv'];
$result = mysqli_query($con,"select * from creditcard where creditcardno='$creditcardno' and cvv='$cvv' and balance>'300' ");
$row=mysqli_fetch_array($result);
$c1=$row[0];
$cardnumber=$row['creditcardno'];
if($c1)
echo implode(" ",array('Yes',$cardnumber));
else
echo "No";
mysqli_close($con);
?>
