package com.appscyclone.androidtvdemo.dagger.components;

import com.appscyclone.androidtvdemo.dagger.AppScope;
import com.appscyclone.androidtvdemo.dagger.modules.ApplicationModule;
import com.appscyclone.androidtvdemo.dagger.modules.HttpClientModule;
import com.appscyclone.androidtvdemo.ui.bases.BaseApplication;
import com.appscyclone.androidtvdemo.ui.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

/*
 * Created by NhatHoang on 09/05/2018.
 */
@AppScope
@Singleton
@Component(modules = {ApplicationModule.class, HttpClientModule.class})
public interface ApplicationComponent {
    void inject(BaseApplication app);
    void inject(MainFragment mainFragment);
}
