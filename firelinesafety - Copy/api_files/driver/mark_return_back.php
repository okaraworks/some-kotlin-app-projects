<?php

   include '../../include/connections.php';

   if($_SERVER['REQUEST_METHOD']==="POST"){
       $bookingID=$_POST['bookingID'];

       $update="UPDATE shipping SET return_back='Returned'WHERE booking_id='$bookingID' AND return_back='Pending return'";
       if(mysqli_query($con,$update)){


           $response['status']='1';
           $response['message']='Updated successfully';
       }else{
           $response['status']='0';
           $response['message']='Failed.';

       }
       print json_encode($response);
   }
