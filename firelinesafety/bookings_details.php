<?php
session_start();
error_reporting(E_ERROR);
include('include/connections.php');


?>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta charset="utf-8" />
    <title><?php echo $siteName?></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <script src="../../cdn-cgi/apps/head/QJpHOqznaMvNOv9CGoAdo_yvYKU.js"></script>
    <link href="assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="assets/plugins/bootstrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/bootstrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="assets/plugins/animate.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/plugins/jquery-scrollbar/jquery.scrollbar.css" rel="stylesheet" type="text/css" />
    <link href="webarch/css/webarch.css" rel="stylesheet" type="text/css" />

    <script>
        if ( window.history.replaceState ) {
            window.history.replaceState( null, null, window.location.href );
        }
    </script>
</head>


<body class="">
<?php
include 'include/navbar.php';
?>

<a href="#" class="scrollup">Scroll</a>
<div class="footer-widget">
<div class="progress transparent progress-small no-radius no-margin">
<div class="progress-bar progress-bar-success animate-progress-bar" data-percentage="79%" style="width: 79%;"></div>
</div>

</div>
<div class="page-content">

<div class="clearfix"></div>
<div class="content">

<div class="page-title">
<h3><span class="semi-bold">Booking details</span></h3>
</div>
<div class="row">
<div class="col-md-12">
<div class="grid simple ">
<div class="grid-title no-border">

</div>
<div class="grid-body no-border">


    <table class="table table-striped table-bordered table-hover" >
        <thead>
        <tr>
            <th>Booking number</th>
            <th>Name</th>
            <th>Contacts</th>
            <th>Amount KSH</th>
            <th>Mpesa code</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <?php
        $select="SELECT * FROM clients c INNER JOIN booking b on c.client_id = b.client_id
        RIGHT JOIN payment p on b.booking_id = p.booking_id WHERE  b.booking_id='".$_GET['get']."'";
        $query=mysqli_query($con,$select);
        while($row=mysqli_fetch_array($query)){
            ?>
            <tr class="odd gradeX">

                <td><?php echo $row['booking_id']?> </td>
                <td><?php echo $row['first_name']. ' '. $row['last_name']?> </td>
                <td> Phone No: <?php echo $row['phone_no']?><br> Email <?php echo $row['email']?> </td>
                <td><?php echo  number_format($row['total_cost'])?> </td>
                <td><?php echo $row['mpesa_code']?> </td>
                <td><?php echo $row['booking_status']?> </td>
            </tr>
            <?php

        }
        ?>

        </tbody>
    </table>


</div>
</div>
</div>
</div>

    <div class="row">
        <div class="col-md-8">
            <div class="grid simple ">
                <div class="grid-title no-border">
                    <h3>Tents</h3>

                    <table class="table table-bordered">
                        <th>Item</th>
                        <th>Capacity</th>
                        <th>Price Ksh</th>
                        <th>quantity</th>
                        <th>Days</th>
                        <th>Subtotal Ksh</th>
                        <?php
                        $select2="SELECT * FROM items i INNER JOIN stock s on i.stock_id = s.stock_id
                       WHERE i.booking_id=".$_GET['get'];
                        $query=mysqli_query($con,$select2);
                        while($row=mysqli_fetch_array($query)){
                        ?>
                        <tr>
                            <td><?php print $row['product_name']?></td>
                            <td><?php print $row['capacity']?></td>
                            <td><?php print  number_format($row['item_price'])?></td>
                            <td><?php print $row['quantity']?></td>
                            <td><?php print $row['no_of_days']?></td>
                            <td><?php print number_format($row['item_price']*$row['quantity']*$row['no_of_days'])?></td>
                        </tr>
                        <?php
                        }
                        ?>
                    </table>


                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="grid simple  ">
                <div class="grid-title no-border table-responsive">
                    <h3>Shipping details</h3>

                    <table class="table table-bordered table-responsive">

                        <?php
                        $select2="SELECT * FROM booking b INNER JOIN towns t on b.town_id=t.town_id
                         RIGHT JOIN counties c on t.county_id = c.county_id
                       WHERE b.booking_id=".$_GET['get'];
                        $query=mysqli_query($con,$select2);
                        $row=mysqli_fetch_array($query);
                        ?>
                        <tr><td>Shipping county </td>  <td><?php print $row['county_name']?></td> </tr>
                        <tr><td>Town </td>   <td><?php print $row['town_name']?></td> </tr>
                        <tr><td>Location desc </td>    <td><?php print $row['location']?></td> </tr>

                    </table>


                </div>
            </div>
        </div>
    </div>
</div>

</div>


</div>
<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>

<script src="assets/plugins/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrapv3/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-block-ui/jqueryblockui.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-numberAnimate/jquery.animateNumbers.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap-select2/select2.min.js" type="text/javascript"></script>


<script src="webarch/js/webarch.js" type="text/javascript"></script>
<script src="assets/js/chat.js" type="text/javascript"></script>

<script src="assets/plugins/jquery-sparkline/jquery-sparkline.js"></script>
<script>
    //TODO AT TO API
    $('table .checkbox input').click(function()
    {
        if ($(this).is(':checked'))
        {
            $(this).parent().parent().parent().toggleClass('row_selected');
        }
        else
        {
            $(this).parent().parent().parent().toggleClass('row_selected');
        }
    });
    // Demo charts - not required 
    $('.customer-sparkline').each(function()
    {
        $(this).sparkline('html',
            {
                type: $(this).attr("data-sparkline-type"),
                barColor: $(this).attr("data-sparkline-color"),
                enableTagOptions: true
            });
    });
</script>
</body>
<script src="dist/js/jquery.dcjqaccordion.2.7.js"></script>
<link type="text/css" rel="stylesheet" href="dist/dataTablesCustom/jquery.dataTables.css?"/>
<script src="dist/dataTablesCustom/jquery.dataTables.min.js"></script>
<script src="dist/dataTablesCustom/dataTables.buttons.min.js"></script>
<script src="dist/dataTablesCustom/buttons.flash.min.js"></script>
<script src="dist/dataTablesCustom/jszip.min.js"></script>
<script src="dist/dataTablesCustom/pdfmake.min.js"></script>
<script src="dist/dataTablesCustom/vfs_fonts.js"></script>
<script src="dist/dataTablesCustom/buttons.html5.min.js"></script>
<script src="dist/dataTablesCustom/buttons.print.min.js"></script>
<script src="dist/dataTablesCustom/buttons.colVis.min.js"></script>

<script>


    $(document).ready(function () {

        var datatable = $('#dataTables-example').dataTable(

            {
                "dom": 'lBfrtip',
                "buttons": [
                    {
                        extend: 'pdf',
                        text:'<i class="fa fa-print btn-xs "> Print </i>',
                        footer: true,
                        exportOptions: {
                            columns: [0,1,2,3,4]
                        }
                    },

                ]

            }
        );

    });
</script>
</html>