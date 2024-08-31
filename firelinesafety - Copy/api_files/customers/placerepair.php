<?php
/**
 * Created by PhpStorm.
 * User: Mwafrika
 * Date: 4/15/2020
 * Time: 12:54 PM
 */


if ($_SERVER['REQUEST_METHOD'] =='POST'){

    require_once '../../include/connections.php';

    // $clientID=$_POST['clientID'];
    // $itemID=$_POST['itemID'];
    // $qty=$_POST['quantity'];
    //  $days=$_POST['days'];
    
    $clientID=$_POST[15];
    $itemID=$_POST[34];
    $qty=$_POST[4];
     $days=$_POST[4];


    $select="SELECT stock FROM stock WHERE stock_id='$itemID'";
    $record=mysqli_query($con,$select);
    $row=mysqli_fetch_array($record);

    if($row['stock']< $qty){

        $response["status"] = 0;
        $response["message"] = $qty. " is more than stock available";
        echo json_encode($response);

    }else{

// check if item exist in client shopping cart

        $select= "SELECT * FROM items  WHERE client_id='$clientID' AND stock_id='$itemID' AND item_status='Cart'";
        $records=mysqli_query($con,$select);
        if($get=mysqli_num_rows($records) >0){
            $response["status"] = 0;
            $response["message"] ='Item exist in  cart. Select another item';
            echo json_encode($response);
        }else{
            // check if client has an active order
            $select="SELECT * FROM booking WHERE client_id='$clientID' AND booking_status='Cart'";
            $record=mysqli_query($con,$select);
            if ($row=mysqli_num_rows($record) < 1 ){
                // if no active order create a new order
                $insert="INSERT INTO booking(client_id)VALUES ('$clientID')";
                mysqli_query($con,$insert);
                // get the order id of the last inserted id
                $orderNo=mysqli_insert_id($con);

                // insert the order items
                $insrt= "INSERT INTO items (client_id,no_of_days, booking_id, stock_id, quantity)
             VALUES ('$clientID','$days','$orderNo', '$itemID', '$qty')";
                if (mysqli_query($con,$insrt)) {
                    $response["status"] = 1;
                    $response["message"] ='Added to shopping cart successfully';
                    echo json_encode($response);

                }else{
                    $response["status"] = 0;
                    $response["message"] ='Failed to add to cart';
                    echo json_encode($response);
                }

            }else{

                // if client has an active order get the order id

                $select="SELECT booking_id,booking_status FROM booking WHERE client_id='$clientID' 
                                                AND booking_status='Cart'";
                $record=mysqli_query($con,$select);
                $rowC=mysqli_fetch_assoc($record);
                $orderNo=$rowC['booking_id'];

                // insert order id and item id, client id and quantity   in to order items

                $insert= "INSERT INTO items (client_id,no_of_days, booking_id, stock_id,quantity)
                  VALUES ('$clientID','$days', '$orderNo', '$itemID', '$qty')";
                if (mysqli_query($con,$insert)) {
                    $response["status"] = 1;
                    $response["message"] ='Added to shopping cart';
                    echo json_encode($response);
                }else{
                    $response["status"] = 0;
                    $response["message"] =$itemID. 'Failed please try again'. $clientID;
                    echo json_encode($response);

                }
            }
        }
    }
}



?>

