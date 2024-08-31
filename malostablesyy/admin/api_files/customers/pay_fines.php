<?php

include "../../include/connections.php";

  if($_SERVER['REQUEST_METHOD']=="POST"){
      $penaltyID=$_POST['penaltyID'];
      $amount=$_POST['amount'];
      $mpesaCode=$_POST['mpesaCode'];

      $update="UPDATE penalty SET penalty_status='Pending approval' WHERE penalty_id='$penaltyID'";
      if(mysqli_query($con,$update)){

          $insert="INSERT INTO penalty_pay( penalty_id, amount_paid, mpesa_code)
         VALUES('$penaltyID','$amount','$mpesaCode')";
          mysqli_query($con,$insert);

          $response['status']="1";
          $response['message']="Submitted";
      }else{
          $response['status']="0";
          $response['message']="Failed to submit";
      }
      print json_encode($response);
  }
