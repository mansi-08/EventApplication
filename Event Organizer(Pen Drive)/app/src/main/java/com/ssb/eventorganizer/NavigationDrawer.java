package com.ssb.eventorganizer;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    DrawerLayout drawer;
    Toolbar toolbar;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    FrameLayout frameLayout;
    //    private ClipData.Item about;
//    private ClipData.Item home;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        frameLayout = findViewById(R.id.content_frame);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawer = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
        {
            NotificationChannel channel =new NotificationChannel("MyNotifications","Mynotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "successfull";
                        if (!task.isSuccessful()) {
                            msg = "failed";
                        }

                        Toast.makeText(NavigationDrawer.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
//        return true;
//    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        Log.d("id", "" + id);
        Toast.makeText(getApplicationContext(), "" + id, Toast.LENGTH_LONG).show();
        if (menuItem.isChecked()) {
            drawer.closeDrawer(GravityCompat.START);
            return false;
        }


        if (id == R.id.nav_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            finish();
//        } else if (id == R.id.nav_home) {
//            Intent intent = new Intent(this, Main3Activity.class);
//            startActivity(intent);
//            finish();
        } else if (id == R.id.nav_eminent_personalities) {

            Intent intent = new Intent(this, Personalities.class);
            startActivity(intent);
            finish();

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;

//           case R.id.nav_eminent_personalities:


        // return true;
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
