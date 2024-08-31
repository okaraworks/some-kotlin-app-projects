<?php

  include '../../include/connections.php';

  if($_SERVER['REQUEST_METHOD']==='POST'){
      $bookingID=$_POST['bookingID'];

      $update="UPDATE shipping SET return_back='Return confirmed'
     WHERE booking_id='$bookingID'AND return_back='Returned'";
      if(mysqli_query($con,$update)){

          $select="SELECT * FROM items WHERE booking_id='$bookingID'";
          $qry=mysqli_query($con,$select);
          while ($row=mysqli_fetch_array($qry)){
              $quantity=$row['quantity'];
              $update2="UPDATE stock SET stock=stock+'$quantity' WHERE stock_id=".$row['stock_id'];
              $qry2=mysqli_query($con,$update2);
          }

          $response['status']='1';
          $response['message']='Updated successfully';

      }else{
          $response['status']='0';
          $response['message']='Failed to update';
      }

     print json_encode($response);
  }
