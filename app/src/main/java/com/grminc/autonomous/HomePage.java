package com.grminc.autonomous;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.anastr.speedviewlib.SpeedView;

public class HomePage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        SpeedView speedometer = findViewById(R.id.speedView);
        speedometer.speedTo(50, 4000);
    }
}
