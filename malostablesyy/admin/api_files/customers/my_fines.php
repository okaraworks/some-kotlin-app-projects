<?php

include '../../include/connections.php';

$clientID=$_POST['userID'];
//$clientID=$_POST['23'];
//creating a query
$select = "SELECT b.booking_id,b.date_to_deliver,b.booking_remark,p.amount,p.remarks,
       p.penalty_id,p.penalty_id,p.penalty_status,p.amount
 FROM booking b INNER JOIN penalty p on b.booking_id = p.booking_id
          RIGHT JOIN clients c2 on b.client_id = c2.client_id 
WHERE b.client_id='$clientID'ORDER BY b.booking_id DESC";

$query=mysqli_query($con,$select);
if(mysqli_num_rows($query)>0){
    $results= array();
    $results['status'] = "1";
    $results['details'] = array();
    $results['message']="Fines";
    while ($row=mysqli_fetch_array($query)){
        $temp = array();

        $temp['bookingID'] = $row['booking_id'];
        $temp['penaltyID'] = $row['penalty_id'];
        $temp['amount'] = $row['amount'];
        $temp['fineStatus'] =$row['penalty_status'];
        $temp['remarks'] =$row['remarks'];

        $select="SELECT * FROM penalty_pay WHERE penalty_id=".$row['penalty_id'];
        $qry=mysqli_query($con,$select);
        if(mysqli_fetch_array($qry)>0){
            $row2=mysqli_fetch_array($qry);
            $temp['mpesaCode']=$row2['mpesa_code'];
        }else{
            $temp['mpesaCode']="NONE";
        }
        array_push($results['details'],$temp);

    }


}else{
    $results['status'] = "0";
    $results['message'] = "No record found";

}
//displaying the result in json format
echo json_encode($results);


?>