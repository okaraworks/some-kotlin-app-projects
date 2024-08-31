<?php

 include '../../include/connections.php';

  $select="SELECT * FROM shipping s INNER JOIN employees e on s.emp_id = e.emp_id 
        WHERE s.return_back='Returned'";
  $query=mysqli_query($con,$select);
  if(mysqli_num_rows($query)>0){
      $response['status']='1';
      $response['details']=array();

      while($row=mysqli_fetch_array($query)){
          $index['bookingID']=$row['booking_id'];
          $index['staffName']=$row['f_name'].' '.$row['l_name'];
          $index['phoneNo']=$row['contact'];
          $index['returnStatus']=$row['return_back'];

          array_push($response['details'],$index);
      }

  }else{
      $response['status']='0';
      $response['message']='No record found';
  }

  print json_encode($response);
