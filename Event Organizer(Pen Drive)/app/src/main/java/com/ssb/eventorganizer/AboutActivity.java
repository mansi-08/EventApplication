package com.ssb.eventorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class AboutActivity extends NavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
       // getLayoutInflater().inflate(R.layout.activity_about, frameLayout);


    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)  {
//        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
//                && keyCode == KeyEvent.KEYCODE_BACK
//                && event.getRepeatCount() == 0) {
//            Log.d("CDA", "onKeyDown Called");
//            onBackPressed();
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @Override
//    public void onBackPressed() {
//        Log.d("CDA", "onBackPressed Called");
//        Intent setIntent = new Intent(Intent.ACTION_MAIN);
//        setIntent.addCategory(Intent.CATEGORY_HOME);
//        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(setIntent);
//    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,NavigationDrawer.class);
        startActivity(intent);
    }
}
