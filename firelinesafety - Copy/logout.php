<?php

ob_start();
   session_status();

   session_destroy();
   session_unset();
   header('location:index.php');

   ob_end_flush();
