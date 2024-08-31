<?php

include '../../include/connections.php';


$clientID=$_POST['clientID'];

//creating a query
$select = "SELECT b.booking_id,b.booking_status,b.date_to_deliver,b.booking_date,b.booking_remark,
       p.delivery_cost,p.mpesa_code,p.total_cost,
          p.delivery_cost,p.booking_cost  FROM booking b INNER JOIN payment p on b.booking_id = p.booking_id
        WHERE b.client_id='$clientID'ORDER BY b.booking_id DESC";

  $query=mysqli_query($con,$select);

  if(mysqli_num_rows($query)>0){
      $results= array();
      $results['status'] = "1";
      $results['details'] = array();
      $results['message']="Bookings";
      while ($row=mysqli_fetch_array($query)){
          $temp = array();

          $temp['bookingID'] = $row['booking_id'];
          $temp['bookingStatus'] = $row['booking_status'];
          $temp['dateToDeliver'] = $row['date_to_deliver'];
          $temp['mpesaCode'] = $row['mpesa_code'];
          $temp['deliveryCost'] = $row['delivery_cost'];
          $temp['bookingCost'] = $row['booking_cost'];
          $bDate = $row['booking_date'];
          $temp['bookingDate'] = date("d-m-Y", strtotime($bDate));
          $temp['bookingRemarks'] = $row['booking_remark'];


          array_push($results['details'], $temp);




  }

}else{
      $results['status'] = "0";
      $results['message'] = "No booking found";
      echo json_encode($results);

  }
echo json_encode($results);



?>