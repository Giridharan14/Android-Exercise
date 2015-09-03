package com.giridharan.frag1;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class page1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment

        return inflater.inflate( R.layout.activity_page1, container, false);
    }
}