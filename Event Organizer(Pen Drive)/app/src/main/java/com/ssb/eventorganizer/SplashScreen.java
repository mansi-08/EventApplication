package com.ssb.eventorganizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class SplashScreen extends AppCompatActivity
{

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,Login.class);
                startActivity(intent);
                finish();
            }
        },3000);
       /* SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if (pref.getBoolean("activity_executed", false)) {
            Intent intent = new Intent(this, NavigationDrawer.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, SplashScreen.class);
            startActivity(intent);
            finish();
        }*/
        /*if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
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

                        Toast.makeText(SplashScreen.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });*/
    }
}
