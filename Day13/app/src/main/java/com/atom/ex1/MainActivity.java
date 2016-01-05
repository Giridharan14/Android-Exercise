package com.atom.ex1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
LinearLayout linearLayout;
    TextView tv;
    View vi=null;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=(LinearLayout) findViewById(R.id.linear1);
        for (i = 0; i < 5; i++)
        {
            tv = new TextView(this);
            tv.setText("Dynamic TextView" + i + " ");
    tv.setTextColor(getResources().getColor(R.color.YOURCOLOR2));
            tv.setId(i);
            tv.setTag("" + i);
            tv.setPadding(2, 2, 2, 2);
            tv.setOnClickListener(this);
            linearLayout.addView(tv);

        }

    }
    public void onClick(View v){
        Toast.makeText(v.getContext(), "Toast " + v.getTag(),
                Toast.LENGTH_SHORT).show();
if(vi==null){
        ((TextView) v).setTextColor(getResources().getColor(R.color.YOURCOLOR1));
        System.out.println(v.getTag()+" here ");
    vi=v;
}
        else if(vi!=null){
    ((TextView) vi).setTextColor(getResources().getColor(R.color.YOURCOLOR2));
    ((TextView) v).setTextColor(getResources().getColor(R.color.YOURCOLOR1));
    System.out.println(v.getTag()+" here ");
    vi=v;
}
    }


}



