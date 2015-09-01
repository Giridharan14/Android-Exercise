package com.giridharan.chkbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends Activity {
    CheckBox ch1,ch2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch1=(CheckBox)findViewById(R.id.checkBox1);
        ch2=(CheckBox)findViewById(R.id.checkBox2);

        Button b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(MainActivity.this, "check box1: "+ch1.isChecked()+"\ncheckbox2: "+ch2.isChecked(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
