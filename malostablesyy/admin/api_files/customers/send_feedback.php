<?php

include '../../include/connections.php';

//insert

if ($_SERVER['REQUEST_METHOD'] =='POST') {

    $feedback = $_POST['feedback'];
    $userID = $_POST['userID'];

    $insert="INSERT INTO feedback(comment,client_id)VALUES 
                  ('$feedback','$userID')";
    if(mysqli_query($con,$insert)){
    $response["status"] = 1;
    $response["message"] = "Sent";
        } else {
        $response["status"] = 0;
        $response["message"] = "Something went wrong";
    }
    echo json_encode($response);
}




