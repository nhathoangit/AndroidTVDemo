package com.appscyclone.androidtvdemo.ui.bases;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.appscyclone.androidtvdemo.R;

/*
 * Created by NhatHoang on 08/05/2018.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frmContainer, fragment);
        fragmentTransaction.commit();
    }
}
