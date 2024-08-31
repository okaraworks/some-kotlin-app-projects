<?php

include "../../include/connections.php";


 if($_SERVER['REQUEST_METHOD']=='POST'){

     $penaltyID=$_POST['penaltyID'];

     $update="UPDATE penalty SET penalty_status='Approved'WHERE penalty_id='$penaltyID'";
     if(mysqli_query($con,$update)){

         $update="UPDATE penalty_pay SET pay_status='Approved'WHERE penalty_id='$penaltyID'";
         mysqli_query($con,$update);

         $response['status']=1;
         $response['message']='Approved successfully';

     }else{
         $response['status']=0;
         $response['message']='Please try again';


     }
     echo json_encode($response);
      }
?>