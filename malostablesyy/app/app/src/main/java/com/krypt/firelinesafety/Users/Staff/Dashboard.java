package com.krypt.firelinesafety.Users.Staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.krypt.firelinesafety.LoginActivity;
import com.krypt.firelinesafety.R;
import com.krypt.firelinesafety.Users.Staff.Driver.Assignment;
import com.krypt.firelinesafety.Users.Staff.Driver.Issued;
import com.krypt.firelinesafety.Users.Staff.Driver.ItemsToReturn;
import com.krypt.firelinesafety.Users.Staff.Driver.MyReturns;
import com.krypt.firelinesafety.Users.Staff.Driver.Mydeliveries;
import com.krypt.firelinesafety.Users.Staff.Finance.Approved;
import com.krypt.firelinesafety.Users.Staff.Finance.FeedbackFinance;
import com.krypt.firelinesafety.Users.Staff.Finance.FineHistory;
import com.krypt.firelinesafety.Users.Staff.Finance.NewBookings;
import com.krypt.firelinesafety.Users.Staff.Finance.NewFines;
import com.krypt.firelinesafety.Users.Staff.Finance.Rejected;

import com.krypt.firelinesafety.Users.Staff.Shipping.Delivered;
import com.krypt.firelinesafety.Users.Staff.Shipping.PendingShipping;
import com.krypt.firelinesafety.Users.Staff.Shipping.PendingShippingServ;
import com.krypt.firelinesafety.Users.Staff.Shipping.PendingShippingSuper;
import com.krypt.firelinesafety.Users.Staff.Shipping.PendingShippingTechs;
import com.krypt.firelinesafety.Users.Staff.Shipping.Shipping;
import com.krypt.firelinesafety.Users.Staff.Store_man.ConfirmedReturns;
import com.krypt.firelinesafety.Users.Staff.Store_man.PendingConfirmReturn;
import com.krypt.firelinesafety.Users.Staff.Store_man.StoreItems;
import com.krypt.firelinesafety.Users.Staff.Supervisor.BookingFines;
import com.krypt.firelinesafety.Users.Staff.Supervisor.FeedbackService;
import com.krypt.firelinesafety.Users.Staff.Supervisor.PendingReturn;
import com.krypt.firelinesafety.Users.Staff.Supervisor.Returned;
import com.krypt.firelinesafety.Users.Staff.Supervisor.ShippingBack;
import com.krypt.firelinesafety.Users.Staff.Supervisor.Technician.Assigned;
import com.krypt.firelinesafety.Users.Staff.Trainee.Trainee;
import com.krypt.firelinesafety.utils.SessionHandler;
import com.krypt.firelinesafety.utils.UserModel;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View contextView;
    private SessionHandler session;
    private UserModel user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);

        contextView = findViewById(android.R.id.content);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        session = new SessionHandler(getApplicationContext());
        user = session.getUserDetails();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {



                    case R.id.id_trainee:
                        Intent tr = new Intent(getApplicationContext(), Trainee.class);
                        startActivity(tr);
                        break;
                    case R.id.nav_new_bookings:
                        Intent hm = new Intent(getApplicationContext(), NewBookings.class);
                        startActivity(hm);
                        break;

                    case R.id.nav_approvedBookings:
                        Intent p = new Intent(getApplicationContext(), Approved.class);
                        startActivity(p);
                        break;

                    case R.id.nav_rejectedBookings:
                        Intent r = new Intent(getApplicationContext(), Rejected.class);
                        startActivity(r);
                        break;

                    case R.id.nav_new_fines:
                        Intent n = new Intent(getApplicationContext(), NewFines.class);
                        startActivity(n);
                        break;


                    case R.id.nav_approved_fine_pay:
                        Intent an = new Intent(getApplicationContext(), FineHistory.class);
                        startActivity(an);
                        break;

                    case R.id.nav_tents_to_deliver:
                        Intent rd = new Intent(getApplicationContext(), PendingShipping.class);
                        startActivity(rd);
                        break;


                    case R.id.servicetodel:
                        Intent sd = new Intent(getApplicationContext(), PendingShippingServ.class);
                        startActivity(sd);
                        break;

                    case R.id.tech_assign:
                        Intent tas = new Intent(getApplicationContext(), PendingShippingTechs.class);
                        startActivity(tas);
                        break;
                    case R.id.supervisor_assign:
                        Intent sds = new Intent(getApplicationContext(), PendingShippingSuper.class);
                        startActivity(sds);
                        break;
                    case R.id.nav_shipping:
                        Intent sh = new Intent(getApplicationContext(), Shipping.class);
                        startActivity(sh);
                        break;
                    case R.id.nav_delivered_:
                        Intent dd = new Intent(getApplicationContext(), Delivered.class);
                        startActivity(dd);
                        break;
                    case R.id.nav_assigned_bookings:
                        Intent aa = new Intent(getApplicationContext(), Assignment.class);
                        startActivity(aa);
                        break;
                    case R.id.services_to_supervise:
                        Intent sts = new Intent(getApplicationContext(), Assignment.class);
                        startActivity(sts);
                        break;
                    case R.id.nav_assigned_tech:
                        Intent aas= new Intent(getApplicationContext(), Assigned.class);
                        startActivity(aas);
                        break;
                    case R.id.nav_issued:
                        Intent ii = new Intent(getApplicationContext(), Issued.class);
                        startActivity(ii);
                        break;
                    case R.id.nav_my_deliveries:
                        Intent md = new Intent(getApplicationContext(), Mydeliveries.class);
                        startActivity(md);
                        break;
                    case R.id.nav_stock:
                        Intent s = new Intent(getApplicationContext(), StoreItems.class);
                        startActivity(s);
                        break;
                    case R.id.nav_items_returned:
                        Intent nrs = new Intent(getApplicationContext(), PendingConfirmReturn.class);
                        startActivity(nrs);
                        break;
                    case R.id.nav_return_hist:
                        Intent cc = new Intent(getApplicationContext(), ConfirmedReturns.class);
                        startActivity(cc);
                        break;
                    case R.id.nav_pending_return:
                        Intent pr = new Intent(getApplicationContext(), PendingReturn.class);
                        startActivity(pr);
                        break;
                    case R.id.nav_shipping_back:
                        Intent sb = new Intent(getApplicationContext(), ShippingBack.class);
                        startActivity(sb);
                        break;
                    case R.id.nav_issued_fines:
                        Intent ff = new Intent(getApplicationContext(), BookingFines.class);
                        startActivity(ff);
                        break;

                    case R.id.nav_returned:
                        Intent rr = new Intent(getApplicationContext(), Returned.class);
                        startActivity(rr);
                        break;


                    case R.id.nav_to_return:
                        Intent ro = new Intent(getApplicationContext(), ItemsToReturn.class);
                        startActivity(ro);
                        break;


                    case R.id.nav_my_returns:
                        Intent mm = new Intent(getApplicationContext(), MyReturns.class);
                        startActivity(mm);
                        break;

                    case R.id.servicefeedback:
                        Intent ss = new Intent(getApplicationContext(), FeedbackService.class);
                        startActivity(ss);
                        break;
                    case R.id.feedbackf:
                        Intent ffeed = new Intent(getApplicationContext(), FeedbackFinance.class);
                        startActivity(ffeed);
                        break;





                    case R.id.nav_logout:
                        alertLogout();

                        break;


                }
                drawer.closeDrawer(GravityCompat.START, true);
                return false;
            }

        });
        drawer.closeDrawers();

        statusLogin();
    }

    public void alertLogout() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage("Do you want to logout?");
        alertDialog.setCancelable(false);
        alertDialog.setButton("Yes logout", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                session.logoutUser();
                Toast toast = Toast.makeText(getApplicationContext(), "You are logged out", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 250);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();

                return;
            }
        });
        alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                return;
            }
        });
        alertDialog.show();
    }

    private void statusLogin() {
        //tech_assign
        navigationView.getMenu().findItem(R.id.services_to_supervise).setVisible(false);

        navigationView.getMenu().findItem(R.id.tech_assign).setVisible(false);

        navigationView.getMenu().findItem(R.id.supervisor_assign).setVisible(false);
        navigationView.getMenu().findItem(R.id.feedbackf).setVisible(false);
        navigationView.getMenu().findItem(R.id.servicetodel).setVisible(false);
        navigationView.getMenu().findItem(R.id.servicefeedback).setVisible(false);
        navigationView.getMenu().findItem(R.id.all_events).setVisible(false);
        navigationView.getMenu().findItem(R.id.services_to_deliver).setVisible(false);
        navigationView.getMenu().findItem(R.id.id_trainee).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_rejected_service).setVisible(false);


        navigationView.getMenu().findItem(R.id.nav_new_bookings).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_approvedBookings).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_rejectedBookings).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_issued_fines).setVisible(false);

        navigationView.getMenu().findItem(R.id.nav_shipping).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_assigned_bookings).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_assigned_tech).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_tents_to_deliver).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_my_deliveries).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_to_return).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_my_returns).setVisible(false);

        navigationView.getMenu().findItem(R.id.nav_issued).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_delivered_).setVisible(false);

        navigationView.getMenu().findItem(R.id.nav_stock).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_items_returned).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_return_hist).setVisible(false);

        navigationView.getMenu().findItem(R.id.nav_pending_return).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_shipping_back).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_returned).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_new_fines).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_approved_fine_pay).setVisible(false);


        if (user.getUser_type().equals("Finance")) {

            navigationView.getMenu().findItem(R.id.nav_new_bookings).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_approvedBookings).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_rejectedBookings).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_new_fines).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_approved_fine_pay).setVisible(true);
            navigationView.getMenu().findItem(R.id.feedbackf).setVisible(true);
        }
        if (user.getUser_type().equals("Service manager")) {
            navigationView.getMenu().findItem(R.id.tech_assign).setVisible(true);

            navigationView.getMenu().findItem(R.id.nav_shipping).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_delivered_).setVisible(true);


            navigationView.getMenu().findItem(R.id.services_to_deliver).setVisible(true);
            //   navigationView.getMenu().findItem(R.id.id_trainee).setVisible(true);
            navigationView.getMenu().findItem(R.id.servicefeedback).setVisible(true);
            navigationView.getMenu().findItem(R.id.servicetodel).setVisible(true);
            navigationView.getMenu().findItem(R.id.supervisor_assign).setVisible(true);



           // navigationView.getMenu().findItem(R.id.nav_pending_return).setVisible(true);
         //   navigationView.getMenu().findItem(R.id.nav_shipping_back).setVisible(true);
          //  navigationView.getMenu().findItem(R.id.nav_returned).setVisible(true);
          //  navigationView.getMenu().findItem(R.id.nav_issued_fines).setVisible(true);
        }

        if (user.getUser_type().equals("Driver")) {

            navigationView.getMenu().findItem(R.id.nav_assigned_bookings).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_issued).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_my_deliveries).setVisible(true);

            navigationView.getMenu().findItem(R.id.nav_to_return).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_my_returns).setVisible(true);
        }
        if (user.getUser_type().equals("Technician")) {

            navigationView.getMenu().findItem(R.id.nav_assigned_tech).setVisible(true);
//            navigationView.getMenu().findItem(R.id.nav_issued).setVisible(true);
//            navigationView.getMenu().findItem(R.id.nav_my_deliveries).setVisible(true);
//
//            navigationView.getMenu().findItem(R.id.nav_to_return).setVisible(true);
//            navigationView.getMenu().findItem(R.id.nav_my_returns).setVisible(true);
        }
        if (user.getUser_type().equals("Stock manager")) {

            navigationView.getMenu().findItem(R.id.nav_stock).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_items_returned).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_return_hist).setVisible(false);

        }
        if(user.getUser_type().equals("Dispatch manager")){

            navigationView.getMenu().findItem(R.id.nav_tents_to_deliver).setVisible(true);

        }
        if(user.getUser_type().equals("Supervisor")){
           navigationView.getMenu().findItem(R.id.services_to_supervise).setVisible(true);

        }

       if(user.getUser_type().equals("Trainee")){

            navigationView.getMenu().findItem(R.id.nav_pending_return).setVisible(true);
           navigationView.getMenu().findItem(R.id.nav_shipping_back).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_returned).setVisible(true);
            navigationView.getMenu().findItem(R.id.nav_issued_fines).setVisible(true);
       }
    }

}