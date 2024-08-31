<?php

include '../../include/connections.php';




//creating a query
$select = "SELECT b.booking_id,b.date_to_deliver,b.booking_remark,b.booking_date,b.county_id,b.town_id,b.address,
          p.amount,p.remarks,p.penalty_status,p.amount,
c2.first_name,c2.last_name FROM booking b INNER JOIN penalty p on b.booking_id = p.booking_id
          RIGHT JOIN clients c2 on b.client_id = c2.client_id
WHERE p.penalty_status='Pending payment'OR p.penalty_status='Pending approval' OR p.penalty_status='Approved'ORDER BY b.booking_id DESC";

$query=mysqli_query($con,$select);
if(mysqli_num_rows($query)>0){
    $results= array();
    $results['status'] = "1";
    $results['details'] = array();
    $results['message']="Pending return";
    while ($row=mysqli_fetch_array($query)){
        $temp = array();

        $temp['bookingID'] = $row['booking_id'];
        $temp['name'] = $row['first_name'].' '.$row['last_name'];
        $temp['address'] = $row['address'];
        $temp['amount'] = $row['amount'];
        $temp['fineStatus'] =$row['penalty_status'];
        $temp['remarks'] =$row['remarks'];

        // get county

        $sel="SELECT county_name FROM counties WHERE county_id='".$row['county_id']."'";
        $qury=mysqli_query($con,$sel);
        $rowC=mysqli_fetch_array($qury);
        $temp['county'] = $rowC['county_name'];

        // get town name

        $selT="SELECT town_name FROM towns WHERE town_id='".$row['town_id']."'";
        $quryT=mysqli_query($con,$selT);
        $rowT=mysqli_fetch_array($quryT);
        $temp['town'] = $rowT['town_name'];

        array_push($results['details'], $temp);

    }


}else{
    $results['status'] = "0";
    $results['message'] = "No record found";

}
//displaying the result in json format
echo json_encode($results);


?>