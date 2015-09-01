package com.giridharan.lv_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	 ListView listview;

	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	String d="8";
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        listview = (ListView) findViewById(R.id.listview);
	        listview.setAdapter(    new yourAdapter( this, new String[] { "data1",
	                "data2" } )    );
	    }
	}