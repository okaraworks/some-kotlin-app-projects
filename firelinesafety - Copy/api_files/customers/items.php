<?php

include '../../include/connections.php';

$bookingID=$_POST['bookingID'];



      $select = "SELECT s.product_name,s.stock_id,s.price,s.capacity,oi.item_id,oi.quantity,oi.no_of_days FROM stock s 
  INNER JOIN items oi on s.stock_id = oi.stock_id  WHERE oi.booking_id='$bookingID'";
      $query=mysqli_query($con,$select);
    $results['status'] = "1";
$results['details'] = array();
      while ($row=mysqli_fetch_array($query)){


          $temp['quantity'] = $row['quantity'];
          $temp['itemPrice'] = $row['price'];
          $temp['itemsName'] = $row['product_name'];
          $temp['price'] = $row['price'];
          $temp['days'] = $row['no_of_days'];
          $temp['capacity'] = $row['capacity'];
          $temp['subTotal'] = $row['price'] * $row['quantity']*$row['no_of_days'];
          array_push($results['details'], $temp);

      }

   print json_encode($results);
