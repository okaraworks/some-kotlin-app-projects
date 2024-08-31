<?php

include "../../include/connections.php";


 if($_SERVER['REQUEST_METHOD']=='POST'){

     $bookingID=$_POST['bookingID'];
     $remarks=$_POST['remarks'];

     $update="UPDATE booking SET booking_status='Rejected',booking_remark='$remarks' 
             WHERE booking_id='$bookingID'";
     if(mysqli_query($con,$update)){

         $response['status']=1;
         $response['message']='Approved successfully';

     }else{
         $response['status']=0;
         $response['message']='Please try again';


     }
     echo json_encode($response);
      }
?>