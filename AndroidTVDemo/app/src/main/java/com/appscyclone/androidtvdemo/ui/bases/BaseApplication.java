package com.appscyclone.androidtvdemo.ui.bases;

import android.app.Application;

import com.appscyclone.androidtvdemo.dagger.components.ApplicationComponent;
import com.appscyclone.androidtvdemo.dagger.components.DaggerApplicationComponent;
import com.appscyclone.androidtvdemo.dagger.modules.ApplicationModule;
import com.appscyclone.androidtvdemo.dagger.modules.HttpClientModule;

/*
 * Created by NhatHoang on 09/05/2018.
 */
public class BaseApplication extends Application {
    private static BaseApplication instance;
    private ApplicationComponent mApplicationComponent;

    public static BaseApplication instance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // Creates Dagger Graph
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .httpClientModule(new HttpClientModule())
                .build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent appComponent() {
        return mApplicationComponent;
    }
}
