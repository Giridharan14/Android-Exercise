package com.giridharan.dblogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class example extends AppCompatActivity {
    EditText welcome,hai,Conform;
    Button Ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        welcome = (EditText)findViewById(R.id.editText);
        hai = (EditText)findViewById(R.id.editText2);
        Conform = (EditText)findViewById(R.id.editText3);
        Ok = (Button)findViewById(R.id.button);


      Ok.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              if (hai.getText().toString().equals(Conform.getText().toString())) {

                  RegisterAdapter sdba = new RegisterAdapter(example.this);
                  try {
                      sdba.open();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
                  long value = sdba.insert(welcome.getText().toString(), hai.getText().toString());
                  sdba.close();
                  if (value != 0) {

                      AlertMessage("Added Successfully...!");

                  } else

                  {
                      AlertMessage("Added Failed...!");


                  }

              };
              Intent i = new Intent(example.this, Login.class);
              startActivity(i);


          }


          private void AlertMessage(String s) {
              Toast.makeText(example.this, s, Toast.LENGTH_LONG).show();
          }
      });
    }
}
