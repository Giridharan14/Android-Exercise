package com.giridharan.dblogin;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;

public class User extends AppCompatActivity {


    ListView listViewObj;

    String[] nameList;
    String[] passList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
// creating a list view here
        listViewObj = (ListView) findViewById(R.id.listViewObj);
//calling database function : in this function the database is assin to the array

        getValuesFromDatabase();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nameList);

        listViewObj.setAdapter(adapter);

        listViewObj.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(), nameList[position],
                        Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void getValuesFromDatabase() {
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

            //	passList = new String[cr.getCount()];
            for (int i = 0; i < cr.getCount(); i++) {

                cr.moveToPosition(i);

                String userNameStr = cr.getString(cr.getColumnIndex(RegisterAdapter.UName));
                //		    String Addrestr		= cr.getString(cr.getColumnIndex(RegisterAdapter.Address));
                nameList[i] = userNameStr;
//				passList[i] = Addrestr;


				/*
				 * String address = cr.getString(cr
				 * .getColumnIndex(RegisterAdapter.Address)); String phone =
				 * cr.getString(cr .getColumnIndex(RegisterAdapter.PhoneNO));
				 *
				 * String mailid = cr.getString(cr
				 * .getColumnIndex(RegisterAdapter.Mailid));
				 */

            }

        }

    }
}
