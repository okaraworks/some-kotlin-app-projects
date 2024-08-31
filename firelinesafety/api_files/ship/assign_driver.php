<?php

   include '../../include/connections.php';

   if($_SERVER['REQUEST_METHOD']==="POST"){
       $bookingID=$_POST['bookingID'];
       $driverID=$_POST['driverID'];

       $update="UPDATE booking SET booking_status='Shipping'WHERE booking_id='$bookingID'";
       if(mysqli_query($con,$update)){

           $insert="INSERT INTO shipping(emp_id, booking_id) VALUES('$driverID','$bookingID')";
           mysqli_query($con,$insert);
           $response['status']='1';
           $response['message']='Delivery successfully assigned';
       }else{
           $response['status']='0';
           $response['message']='Failed.';

       }
       print json_encode($response);
   }
