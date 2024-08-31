
<?php
session_start();
error_reporting(E_ERROR);
include 'include/connections.php';
ob_start();
if(isset($_POST['btn_login'])){
    $username=$_POST['username'];
    $password=$_POST['password'];
    if(empty($username)||empty($password)){
        $swal='error';
        $fb='Please enter both username and password';
    }else{
        $select="SELECT * FROM employees WHERE username='$username' AND password='$password'";
        $record=mysqli_query($con,$select);
        if($check=mysqli_num_rows($record)>0){
            $row=mysqli_fetch_array($record);
            $_SESSION['IDstaff']=$row['emp_id'];
            $_SESSION['userlevel']=$row['userlevel'];
                header('location:products.php');
                echo'success.';
                $fb='Logged in.';
        }else{
            $swal='error';
            $fb=' Please confirm your username and password';
        }
    }
}
ob_end_flush();
?>


<html>

<script src="js/jquery.min.js"></script>
<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>Fireline Safety</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta content="" name="description" />
<meta content="" name="author" />

<link href="assets/plugins/bootstrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/animate.min.css" rel="stylesheet" type="text/css" />


<link href="webarch/css/webarch.css" rel="stylesheet" type="text/css" />

</head>


<body class="error-body no-top">
<div class="container">
    <h1 class="center-text"><?php echo $siteName_fl?></h1>
<div class="row login-container column-seperation">
<div class="col-md-4 col-md-offset-4">

    <?php
    echo '<div class="alert alert-danger">'.$fb."</div>";
    ?>

<br>
<form  class="login-form validate" id="login-form" method="post" name="login-form" autocomplete="off">
<div class="row">
<div class="form-group col-md-10">

<label class="form-label">Username</label>
<input class="form-control" id="txtusername" name="username"value="<?php echo $username?>" type="text" required>
</div>
</div>
<div class="row">
<div class="form-group col-md-10">
<label class="form-label">Password</label> <span class="help"></span>
<input class="form-control"  id="txtpassword" name="password"value="<?php echo $password?>" type="password" required>
</div>
</div>
<div class="row">
<div class="control-group col-md-10">

</div>
</div>
<div class="row">
<div class="col-md-10">
<button class="btn btn-primary btn-cons pull-right" type="submit" name="btn_login">Login</button>
</div>
</div>
</form>
</div>
</div>
</div>

<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>

<script src="assets/plugins/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrapv3/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-block-ui/jqueryblockui.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap-select2/select2.min.js" type="text/javascript"></script>


<script src="webarch/js/webarch.js" type="text/javascript"></script>
<script src="assets/js/chat.js" type="text/javascript"></script>

</body>

</html>