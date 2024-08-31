<?php

   include '../../include/connections.php';

   if($_SERVER['REQUEST_METHOD']==="POST"){
       $bookingID=$_POST['bookingID'];
       $username=$_POST['username'];

       $update="UPDATE booking SET booking_status='Collected'WHERE booking_id='$bookingID'";
       if(mysqli_query($con,$update)){

           $select="SELECT * FROM employees WHERE username='$username'";
           $query=mysqli_query($con,$select);
           $row=mysqli_fetch_array($query);
           $driverID=$row['emp_id'];

           $insert="INSERT INTO shipping(emp_id, booking_id,return_back) VALUES('$driverID','$bookingID','Pending return')";
           mysqli_query($con,$insert);
           $response['status']='1';
           $response['message']='Assigned successfully';
       }else{
           $response['status']='0';
           $response['message']='Failed.';

       }
       print json_encode($response);
   }
