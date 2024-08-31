<?php
/**
 * Created by PhpStorm.
 * User: Mwafrika
 * Date: 4/15/2020
 * Time: 12:54 PM
 */


if ($_SERVER['REQUEST_METHOD'] =='POST'){

    require_once '../../include/connections.php';

    $clientID=$_POST['clientID'];
    $stockID=$_POST['stockID'];
    $itemID=$_POST['itemID'];
    $qty=$_POST['quantity'];
    $days=$_POST['days'];

    if(empty($quantity)){
        $response["status"] = 0;
        $response["message"] = 'Enter quantity to update ';
        echo json_encode($response);
    }else{


    $select="SELECT stock FROM stock WHERE stock_id='$stockID'";
    $record=mysqli_query($con,$select);
    $row=mysqli_fetch_array($record);

    if($row['stock']< $qty){

        $response["status"] = 0;
        $response["message"] = 'Quantity should be less or equal to '.$row['stock'];
        echo json_encode($response);

    }else{

        $update="UPDATE items SET quantity='$quantity',no_of_days='$days' WHERE item_id='$itemID'";
        if(mysqli_query($con,$update)){
            $response["status"] = 1;
            $response["message"] = 'Update successfully ';
            echo json_encode($response);
        }else{
            $response["status"] = 0;
            $response["message"] = 'Failed to update!! Please try again';
            echo json_encode($response);
        }

    }
}
}



?>
