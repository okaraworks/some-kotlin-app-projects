<?php

   include '../../include/connections.php';


   $select="SELECT * FROM employees WHERE userlevel='Trainee'";
   $record=mysqli_query($con,$select);

   if(mysqli_num_rows($record)>0){

       $response['status']=1;
       $response['message']="Drivers";

       $response['details']=array();
       while($row=mysqli_fetch_array($record)){

            $index['driverID']=$row['emp_id'];
           $index['driverName']=$row['f_name'].' '.$row['l_name'];

           array_push($response['details'],$index);
       }
   }else{
       $response['status']=0;
       $response['message']="No record found";
   }

   echo json_encode($response);

?>