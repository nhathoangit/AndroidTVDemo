package com.appscyclone.androidtvdemo.ui.detail;

import android.os.Bundle;

import com.appscyclone.androidtvdemo.ui.bases.BaseActivity;

/*
 * Created by NhatHoang on 09/05/2018.
 */
public class MovieDetailActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(new MovieDetailFragment());
    }
}
