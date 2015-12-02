package com.giridharan.dblogin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;

public class Login extends AppCompatActivity {
    EditText Username,Password;
    Button Login,Register;
    String[] nameList;
    String[] passList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username =(EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
        Login = (Button)findViewById(R.id.login);
        Register = (Button)findViewById(R.id.register);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValuesFromDatabase(Username.getText().toString(), Password.getText().toString());


            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this,example.class);
                Bundle b = new Bundle();
                Bundle d = getIntent().getExtras();

                {
                    b.putString("Username", Username.getText().toString());
                    b.putString("Password",Password.getText().toString());

                    i.putExtras(b);
                    startActivity(i);
                }

            }
        });
    }

    private void getValuesFromDatabase(String n,String p) {
        // TODO Auto-generated method stub

        RegisterAdapter sdba = new RegisterAdapter(this);

        try {
            sdba.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Cursor cr = null;
        try {
            cr = sdba.fetch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (cr.getCount() > 0) {

            nameList = new String[cr.getCount()];
        	passList = new String[cr.getCount()];
            for (int i = 0; i < cr.getCount(); i++) {
                cr.moveToPosition(i);
                String userNameStr = cr.getString(cr.getColumnIndex(RegisterAdapter.UName));
                String Addrestr		= cr.getString(cr.getColumnIndex(RegisterAdapter.Passwordi));
                //nameList[i] = userNameStr;
				//passList[i] = Addrestr;
                if(n.equals(userNameStr)&&p.equals(Addrestr))
                {
                    //intent
                    Intent i11 = new Intent(Login.this,User.class);
                    startActivity(i11);
                }


            }

        }

    }

}
