package com.giridharan.intent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent io=new Intent(MainActivity.this,MainActivity2Activity.class);

                Bundle bundle1 = new Bundle();
//Add your data to bundle
                bundle1.putString("ONE", "one11");
                bundle1.putString("TWO", "two11");
//Add the bundle to the intent
                io.putExtras(bundle1);

                startActivity(io);

            }
        });
    }
}
