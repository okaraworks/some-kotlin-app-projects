<?php

include '../../include/connections.php';



    $userID=$_POST['userID'];

//creating a query
$select = "SELECT * FROM clients c INNER JOIN booking b on c.client_id = b.client_id 
RIGHT JOIN shipping s on b.booking_id = s.booking_id WHERE emp_id='$userID'
                                                       AND s.assign_status='Delivered' ORDER BY  b.booking_id DESC";

  $query=mysqli_query($con,$select);
  if(mysqli_num_rows($query)>0){
      $results= array();
      $results['status'] = "1";
      $results['details'] = array();
      while ($row=mysqli_fetch_array($query)){
          $temp = array();

          $temp['bookingID'] = $row['booking_id'];
          $temp['clientName'] = $row['first_name'].' '.$row['last_name'];
          $temp['dateToDeliver'] = $row['date_to_deliver'];
          $temp['location'] = $row['location'];
          $temp['bookingStatus'] = $row['booking_status'];

          // get county

          $sel="SELECT county_name FROM counties WHERE county_id='".$row['county_id']."'";
          $qury=mysqli_query($con,$sel);
          $rowC=mysqli_fetch_array($qury);
          $temp['county'] = $rowC['county_name'];

          // get town name

          $selT="SELECT town_name FROM towns WHERE town_id='".$row['town_id']."'";
          $quryT=mysqli_query($con,$selT);
          $rowT=mysqli_fetch_array($quryT);
          $temp['town'] = $rowT['town_name'];

          array_push($results['details'], $temp);

      }


  }else{
      $results['status'] = "0";
      $results['message'] = "Nothing found";

}
//displaying the result in json format
echo json_encode($results);



//$today = date('Ymd');
//$startDate = date('Ymd', strtotime('-100 days'));
//$range = $today - $startDate;
//$rand = rand(100, 999);
//echo $rand;
//echo "</br>";
//$random = substr(md5(mt_rand()), 0, 2);
//echo $random;

?>