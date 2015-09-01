package com.giridharan.login_form;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    Button b1,b2;
   EditText ed1,ed2;
    TextView tx1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

          b1=(Button)findViewById(R.id.button);
         ed1=(EditText)findViewById(R.id.editText);
         ed2=(EditText)findViewById(R.id.editText2);
         b2=(Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Str = ed1.getText().toString();


                if (ed1.getText().toString().equals(ed2.getText().toString()) {

                    Toast.makeText(MainActivity.this, Str, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Wrong UserName and Password", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
