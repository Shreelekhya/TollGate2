<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$num = $_POST['num'];
$result = mysqli_query($con,"select * from tolluser where vn1='$num' ");
$row=mysqli_fetch_array($result);
if($row)
{
$phn=$row['phone'];
$vt=$row['vt1'];
$tuser=$row['tuser'];
}
$result2 = mysqli_query($con,"select * from tolluser where vn2='$num' ");
$row2=mysqli_fetch_array($result2);
if($row2)
{
$phn=$row2['phone'];
$vt=$row2['vt2'];
$tuser=$row2['tuser'];
}
$result3 = mysqli_query($con,"select * from tolluser where vn3='$num' ");
$row3=mysqli_fetch_array($result3);
if($row3)
{
$phn=$row3['phone'];
$vt=$row3['vt3'];
$tuser=$row3['tuser'];
}
$result4 = mysqli_query($con,"select * from tolluser where vn4='$num' ");
$row4=mysqli_fetch_array($result4);
if($row4)
{
$phn=$row4['phone'];
$vt=$row4['vt4'];
$tuser=$row4['tuser'];
}
if($vt=='Four Wheeler(Light)' && $tuser=='Normal user')
$d=120;
if($vt=='LCV' && $tuser=='Normal user')
$d=150;
if($vt=='Bus/Truck' && $tuser=='Normal user')
$d=180;
if($vt=='3 axle' && $tuser=='Normal user')
$d=210;
if($vt=='Four Wheeler(Light)' && $tuser=='Cab owner')
$d=110;
if($vt=='LCV' && $tuser=='Cab owner')
$d=140;
if($vt=='Bus/Truck' && $tuser=='Cab owner')
$d=170;
if($vt=='3 axle' && $tuser=='Cab owner')
$d=200;
if($vt=='Four Wheeler(Light)' && $tuser=='Government user')
$d=100;
if($vt=='LCV' && $tuser=='Government user')
$d=130;
if($vt=='Bus/Truck' && $tuser=='Government user')
$d=160;
if($vt=='3 axle' && $tuser=='Government user')
$d=190;
$result6 = mysqli_query($con,"update vehicle_data set amountD='$d' where v_num='$num' ");
$result5 = mysqli_query($con,"select sum(amount) from twallet where phone='$phn' ");
$row5=mysqli_fetch_array($result5);
$amt=$row5[0];
if($result){
echo implode(":",array('Yes',$phn,$amt,$d));
}
else
echo "No";
mysqli_close($con);
?>