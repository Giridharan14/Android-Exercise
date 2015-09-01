package com.giridharan.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;


public class MainActivity extends Activity {
    AutoCompleteTextView text;
    MultiAutoCompleteTextView text1;
    String[] languages={"Android","Apple","Blackberry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        text1=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);

        text.setAdapter(adapter);
        text.setThreshold(1);

        text1.setAdapter(adapter);
        text1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

}
