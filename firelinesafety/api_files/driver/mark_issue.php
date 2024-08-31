<?php

include "../../include/connections.php";

 if($_SERVER['REQUEST_METHOD']=='POST'){

     $bookingID=$_POST['bookingID'];

     $update="UPDATE booking SET booking_status='Issued'WHERE booking_id='$bookingID'";
     if(mysqli_query($con,$update)){

         $update="UPDATE shipping SET assign_status='Issued'WHERE booking_id='$bookingID'";
         mysqli_query($con,$update);

         $response['status']=1;
         $response['message']='Update successfully';

     }else{
         $response['status']=0;
         $response['message']='Please try again';

     }
     echo json_encode($response);
      }
?>