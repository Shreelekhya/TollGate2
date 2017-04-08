<?php
$con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
if (file_exists('text.txt')) {
$fd = @fopen("text.txt", "r");

$buffer = fgets($fd, 4096);
$sql = "INSERT INTO vehicle_data (id,v_num) VALUES ('1','$buffer')";   
$result= mysqli_query($con,$sql);
if($result)
echo "Yes";
else
echo "No";

}
else
echo "not found";
?>
 