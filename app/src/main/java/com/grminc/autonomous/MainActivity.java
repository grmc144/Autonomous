package com.grminc.autonomous;

import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean networkStatus = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("b network Status",Boolean.toString(networkStatus));
        networkStatus = isNetworkAvailable();

        if (networkStatus) {

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                public void run() {
                    Intent i = new Intent(MainActivity.this, HomePage.class);
                    startActivity(i);

                }
            }, 5000);


        }else{

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                public void run() {

                    checkNetworkStatus(MainActivity.this);
                }
            }, 5000);

        }

    }
    private boolean isNetworkAvailable() {

        ConnectivityManager cm = (ConnectivityManager) getApplication()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    private void checkNetworkStatus(MainActivity mainActivity) {

        boolean  netstatus = isNetworkAvailable();

        if (netstatus){


            Intent i = new Intent(MainActivity.this, HomePage.class);
            startActivity(i);

        }else{
            Toast.makeText(MainActivity.this,"No internet connection.Please Try again later",
                    Toast.LENGTH_SHORT).show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                public void run() {

                    checkNetworkStatus(MainActivity.this);
                }
            }, 5000);

        }


    }
}
