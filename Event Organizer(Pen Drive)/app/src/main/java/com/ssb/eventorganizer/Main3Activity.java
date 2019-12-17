package com.ssb.eventorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main3Activity extends NavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //getLayoutInflater().inflate(R.layout.activity_main3, frameLayout);

        setTitle("Main3Activity");
    }
}
