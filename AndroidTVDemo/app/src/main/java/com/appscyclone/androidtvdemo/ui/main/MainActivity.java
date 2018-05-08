package com.appscyclone.androidtvdemo.ui.main;

import android.app.Activity;
import android.os.Bundle;

import com.appscyclone.androidtvdemo.R;
import com.appscyclone.androidtvdemo.ui.bases.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new MainFragment());
    }
}
