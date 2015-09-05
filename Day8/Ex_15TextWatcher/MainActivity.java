package com.giridharan.taskcal;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    EditText et1,et2,et3,et4,et5,et6,ett;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         et1= (EditText) findViewById(R.id.editText);
         et2=(EditText) findViewById(R.id.editText2);
        et3= (EditText) findViewById(R.id.editText3);
        et4=(EditText) findViewById(R.id.editText4);
        et5= (EditText) findViewById(R.id.editText5);
        et6=(EditText) findViewById(R.id.editText6);
        ett= (EditText) findViewById(R.id.editText7);


        et1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int i3= Integer.parseInt(ett.getText().toString());
                int i2= Integer.parseInt(et3.getText().toString());
                int i= Integer.parseInt(et2.getText().toString());
                int i1= Integer.parseInt(s.toString());
                et3.setText(Integer.toString(i + i1));
                int k= (i3-i2)+i+i1;
                String ss= Integer.toString(k);
                //ett.s
                ett.setText(ss);
                //et(i2,(i+i1));
            }
        });
        et2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int i= Integer.parseInt(et1.getText().toString());
                int i1= Integer.parseInt(s.toString());
                int i3= Integer.parseInt(ett.getText().toString());
                int i2= Integer.parseInt(et3.getText().toString());
                et3.setText(Integer.toString(i + i1));
                int k= (i3-i2)+i+i1;
                String ss= Integer.toString(k);
                //ett.s
                ett.setText(ss);
            }
        });
/*        et3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                int i= Integer.parseInt(et6.getText().toString());
                int i1= Integer.parseInt(s.toString());

                ett.setText((i+i1)+" ");
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }
        });*/
        et4.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int i= Integer.parseInt(et5.getText().toString());
                int i1= Integer.parseInt(s.toString());
                int i3= Integer.parseInt(ett.getText().toString());
                int i2= Integer.parseInt(et6.getText().toString());
                et6.setText(Integer.toString(i + i1));
                int k= (i3-i2)+i+i1;
                String ss= Integer.toString(k);
                //ett.s
                ett.setText(ss);
            }
        });
        et5.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int i= Integer.parseInt(et4.getText().toString());
                int i1= Integer.parseInt(s.toString());
                int i3= Integer.parseInt(ett.getText().toString());
                int i2= Integer.parseInt(et6.getText().toString());
                et6.setText(Integer.toString(i + i1));
                int k= (i3-i2)+i+i1;
                String ss= Integer.toString(k);
                //ett.s
                ett.setText(ss);
            }
        });
        /*et6.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int i= Integer.parseInt(et5.getText().toString());
                int i1= Integer.parseInt(s.toString());

                ett.setText((i + i1) + " ");
            }
        });*/
    }

}
