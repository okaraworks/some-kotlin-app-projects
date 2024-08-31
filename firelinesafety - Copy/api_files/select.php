<?php

  if($_SERVER['REQUEST_METHOD']=='POST'){

      include '../include/connections.php';
      $select=$_POST['select'];

      if($select=="Customer"){
          include 'customers/login.php';
      }else{
          include 'staff_login.php';
      }
  }

