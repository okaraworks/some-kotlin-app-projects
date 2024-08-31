
<?php
session_start();
error_reporting(E_ERROR);
include 'include/connections.php';
ob_start();

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
<title>Kisa Logistics-admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta content="" name="description" />
<meta content="" name="author" />

<link href="assets/plugins/bootstrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

</head>


<body class="error-body no-top">
<div class="container">
    <h1 class="center-text"><?php echo $siteName?></h1>
<div class="row login-container column-seperation">
    <div class="col-md-6">
        <?php
        include 'include/connections.php';
        $select="SELECT * FROM clients c INNER JOIN payment p on c.client_id = p.client_id
                   RIGHT JOIN orders o on c.client_id = o.client_id
            ORDER BY o.order_id DESC LIMIT 1";
        $query=mysqli_query($con,$select);
        $row=mysqli_fetch_array($query);

            ?>
            <table class="table table-bordered">
                <caption>Order details</caption>
                <tr><td>Order No </td><td><?php echo $row['order_id']?></td></tr>
                <tr><td>Name </td><td><?php echo $row['first_name'].' '.$row['last_name']?></td></tr>
                <tr><td>Cash ksh </td><td><?php echo $row['total_cost']?></td></tr>
                <tr><td>Mpesa code </td><td><?php echo $row['mpesa_code']?></td></tr>
                <tr><td><b>Status</b> </td><td><?php
                        if($row['order_status']==1){
                            echo $temp['orderStatus'] = "Pending";
                        }elseif ($row['order_status']==2){
                            echo  $temp['orderStatus'] = "Approved";
                        }elseif ( $row['order_status']==3){
                            echo  $temp['orderStatus'] = "Shipping";
                        }elseif ($row['order_status']==4){
                            echo  $temp['orderStatus'] = "Arrived";
                        }elseif ($row['order_status']==5){
                            echo  $temp['orderStatus'] = "Delivered";
                        }
                        ?></td></tr>
            </table>


        <table class="table table-bordered">
            <caption>Order items</caption>
            <th>Item</th>
            <th>Price ksh</th>
            <th>quantity</th>
            <th>Subtotal Ksh</th>
            <?php
            $select="SELECT * FROM order_items oi INNER JOIN stock s on oi.stock_id = s.stock_id 
                      WHERE oi.order_id=".$row['order_id'];
            $query=mysqli_query($con,$select);
            while($rowP=mysqli_fetch_array($query)){
                ?>
                <tr>
                    <td><?php echo $rowP['product_name']?></td>
                    <td><?php echo $rowP['item_price']?></td>
                    <td><?php echo $rowP['quantity']?></td>
                    <td><?php echo $rowP['quantity']*$rowP['item_price']?></td>
                </tr>
            <?php
            }
            ?>
        </table>


    </div>
</div>
</div>

</body>

</html>