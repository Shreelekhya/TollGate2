    <?php
    $con=mysqli_connect("mysql1.000webhost.com","a3114479_sai","sai123","a3114479_Tollg");
     
    if (mysqli_connect_errno($con))
    {
       echo "Failed to connect to MySQL: " . mysqli_connect_error();
    }
    $vnum = $_POST['vnum'];

    $result = mysqli_query($con,"select * from vehicle_data where v_num='$vnum' ");

$v_num = array();
$v_num[0]="Yes";
while($row=mysqli_fetch_assoc($result)){
      //fill array how to fill array that will look like bellow from database???
    $v_num[] = $row['id'].";".$row['v_num'].";".$row['TS'].";".$row['amountD'];
}

if($v_num[1]){
echo implode("/",$v_num);
}

else
echo "No";
    
    mysqli_close($con);
    ?>

