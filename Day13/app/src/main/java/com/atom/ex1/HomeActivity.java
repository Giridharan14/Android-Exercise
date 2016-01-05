package com.atom.ex1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jiju88 on 17-12-2015.
 */
public class HomeActivity extends AppCompatActivity {
    String[] language ={"Common Test","Test by Disease","Test by Gender","Advanced Tests","Full Health Package Female","Full Health Package Male"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        /*Button common  = (Button) findViewById(R.id.commontest);
        common.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent io = new Intent(HomeActivity.this, CommonTest.class);
                startActivity(io);
            }
        });
        Button testbydisease  = (Button) findViewById(R.id.testbydisease);
        testbydisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent io = new Intent(HomeActivity.this, TestbyDisease.class);
                startActivity(io);
            }
        });
        Button testbygender  = (Button) findViewById(R.id.testbygender);
        testbygender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent io = new Intent(HomeActivity.this, TestbyGender.class);
                startActivity(io);
            }
        });
        Button advancedtest  = (Button) findViewById(R.id.advancedtests);
        advancedtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent io = new Intent(HomeActivity.this, AdvancedTests.class);
                startActivity(io);
            }
        });

        Button fullhealthfemale  = (Button) findViewById(R.id.fullhealthfemale);
        fullhealthfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent io = new Intent(HomeActivity.this, FullHealthFemale.class);
                startActivity(io);
            }
        });
        Button fullhealthmale  = (Button) findViewById(R.id.fullhealthmale);
        fullhealthmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent io = new Intent(HomeActivity.this, FullHealthMale.class);
                startActivity(io);
            }
        });

*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

*/
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
     /*       case R.id.wallet:
                Toast.makeText(getApplicationContext(), "Wallet Selected", Toast.LENGTH_LONG).show();
                Intent io=new Intent(HomeActivity.this,Wallet.class);
                startActivity(io);
                return true;
       */     /*case R.id.edit:
                Toast.makeText(getApplicationContext(),"Edit Profile is Selected",Toast.LENGTH_LONG).show();
                Intent i=new Intent(HomeActivity.this,EditProfileActivity.class);
                startActivity(i);
                return true;
            case R.id.contact:
                Toast.makeText(getApplicationContext(),"Contact is Selected",Toast.LENGTH_LONG).show();
                Intent ioo=new Intent(HomeActivity.this,ContactActivity.class);
                startActivity(ioo);
                return true;*/
         /*   case R.id.out:
                Toast.makeText(getApplicationContext(),"Signout",Toast.LENGTH_LONG).show();
                Intent is=new Intent(HomeActivity.this,SigninActivity.class);
                startActivity(is);
                return true;
           */ /*case R.id.Referral:
                Toast.makeText(getApplicationContext(),"Referral is Selected",Toast.LENGTH_LONG).show();
                Intent ir=new Intent(HomeActivity.this,ReferralActivity.class);
                startActivity(ir);
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
