<?php
/**
 * Created by PhpStorm.
 * User: Mwafrika
 * Date: 10/12/2019
 * Time: 11:49 AM
 */

// Make payment

if ($_SERVER['REQUEST_METHOD'] =='POST') {

    include '../../include/connections.php';


    $clientID = $_POST['clientID'];
    $countyID = $_POST['countyID'];
    $townName = $_POST['townName'];
    $address = $_POST['address'];
    $deliveryCost = $_POST['shippingCost'];
    $totalCost = $_POST['totalCost'];
    $bookingCost = $_POST['bookingCost'];
    $mpesaCode = $_POST['mpesaCode'];
    $location = $_POST['location'];
    $deliveryDate = $_POST['deliveryDate'];



   if (empty($townName)) {
        $result['status'] = "0";
        $result['message'] = "Enter address";
        echo json_encode($result);
    } elseif (empty($address)) {
        $result['status'] = "0";
        $result['message'] = "Enter address";
        echo json_encode($result);
    } elseif (empty($mpesaCode)) {
        $result['status'] = "0";
        $result['message'] = "Enter Mpesa code";
        echo json_encode($result);

    } else {

        $select = "SELECT booking_id FROM booking WHERE client_id='$clientID'
                                 AND booking_status='Cart'";
        $query = mysqli_query($con, $select);
        $row = mysqli_fetch_array($query);
        $bookingID = $row['booking_id'];  // booking ID

        // get item price to insert to booking items
        $select = "SELECT s.price FROM items oi INNER JOIN stock s on oi.stock_id = s.stock_id
        WHERE oi.booking_id='$bookingID'";
        $query = mysqli_query($con, $select);
        while ($row = mysqli_fetch_array($query)) {
            $price = $row['price'];  // item price

            // update booking items price
            $update = "UPDATE items SET item_price='$price' WHERE booking_id='$bookingID'";
            if (mysqli_query($con, $update)) {

                    // get town id
                    $slect = "SELECT town_id FROM towns WHERE town_name='$townName' AND county_id='$countyID'";
                    $query = mysqli_query($con, $slect);
                    $row = mysqli_fetch_array($query);
                    $townID = $row['town_id'];


                    $select = "SELECT * FROM delivery WHERE client_id='$clientID'";
                    $query = mysqli_query($con, $select);
                    if (mysqli_num_rows($query) < 1) {
                        // insert the delivery details
                        $insert = "INSERT INTO delivery(county_id, town_id, client_id,address,location) 
              VALUES ('$countyID','$townID','$clientID','$address','$location')";
                        mysqli_query($con, $insert);

                    } else {

                        // if user had submitted delivery details update delivery details in case user change delivery details
                        $update = "UPDATE delivery SET county_id='$countyID',town_id='$townID',address='$address',
                    location='$location' WHERE client_id='$clientID'";
                        mysqli_query($con, $update);

                    }



                    $update = "UPDATE booking SET county_id='$countyID',town_id='$townID',
                   address='$address',location='$location',date_to_deliver='$deliveryDate',booking_date=CURRENT_TIMESTAMP ,
                   booking_status='Pending approval'
                    WHERE booking_id='$bookingID'AND client_id='$clientID'";
                    if (mysqli_query($con, $update)) {

                        $update = "UPDATE items SET item_status='Submitted' WHERE booking_id='$bookingID'";
                        mysqli_query($con, $update);


                        $insert = "INSERT INTO payment(booking_id, mpesa_code, client_id, booking_cost, delivery_cost, total_cost, status)
                          VALUES ('$bookingID','$mpesaCode','$clientID','$bookingCost','$deliveryCost','$totalCost','1')";
                        mysqli_query($con, $insert);



                        $select = "SELECT stock_id,quantity,item_price FROM items WHERE booking_id='$bookingID'";
                        $query = mysqli_query($con, $select);
                        while ($row = mysqli_fetch_array($query)) {

                            $stockID = $row['stock_id'];  // get item id
                            $quantity = $row['quantity']; // get item quantity

                            $update = "UPDATE stock SET stock=stock-'$quantity'WHERE stock_id='$stockID'";
                            mysqli_query($con, $update);

                        }

                        $result['status'] = "1";
                        $result['message'] = "Booking submitted successfully";
                        echo json_encode($result);

                    }

            }else{
                $result['status'] = "0";
                $result['message'] = "Something went long. Please try again" ;
                echo json_encode($result);
            }
        }
    }
}