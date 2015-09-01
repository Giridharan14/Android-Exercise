package com.giridharan.radio1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        btnDisplay=(Button)findViewById(R.id.button2);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioGroup.getCheckedRadioButtonId();

                radioButton=(RadioButton)findViewById(selectedId);

                Toast.makeText(MainActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
}

}
