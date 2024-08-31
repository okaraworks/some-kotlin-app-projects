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
    $townName = $_POST['town'];
    $address = $_POST['address'];
    $location = $_POST['location'];



    if (empty($townName)) {
        $result['status'] = "0";
        $result['message'] = "Enter address";
        echo json_encode($result);
    } elseif (empty($address)) {
        $result['status'] = "0";
        $result['message'] = "Enter address";
        echo json_encode($result);
    } elseif (empty($location)) {
        $result['status'] = "0";
        $result['message'] = "location is required";
        echo json_encode($result);

    } else {


                $slect = "SELECT town_id FROM towns WHERE town_name='$townName' AND county_id='$countyID'";
                $query = mysqli_query($con, $slect);
                $row = mysqli_fetch_array($query);
                $townID = $row['town_id'];


                $select = "SELECT * FROM delivery WHERE client_id='$clientID'";
                $query = mysqli_query($con, $select);
                if (mysqli_num_rows($query) < 1) {


                    $insert = "INSERT INTO delivery(county_id, town_id, client_id,address,location)
                        VALUES ('$countyID','$townID','$clientID','$address','$location')";
                   if( mysqli_query($con, $insert)) {
                       $result['status'] = '1';
                       $result['message'] = 'Shipping details submitted successfully';
                   }else {
                       $result['status'] = '0';
                       $result['message'] = 'Failed to submit';
                   }
                } else {

                    $update = "UPDATE delivery SET county_id='$countyID',town_id='$townID',
                    address='$address',location='$location'WHERE client_id='$clientID'";
                   if( mysqli_query($con, $update)){
                   $result['status'] = '1';
                    $result['message'] = 'Shipping details updated successfully';

                }else{
                        $result['status'] = '0';
                        $result['message'] = 'Failed to update';
                    }
                }


    }
    print json_encode($result);
}