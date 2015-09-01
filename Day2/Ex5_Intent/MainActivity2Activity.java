package com.giridharan.intent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2Activity extends ActionBarActivity {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        Bundle bundle = getIntent().getExtras();
        String text= bundle.getString("ONE");
        text=text +" "+ bundle.getString("TWO");
         Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }
}
