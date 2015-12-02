package com.giridharan.dblogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread th = new Thread() {
            public void run() {
                try {
                    sleep(9000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // onPause();
                    startActivity(new Intent(MainActivity.this,Login.class));
                }
            }
        };
        th.start();
    }
}
