package com.ihs.appli.portfolio;

import android.app.Activity;
import android.app.Application;

import androidx.fragment.app.Fragment;

import com.ihs.appli.portfolio.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MyApplication extends Application implements HasActivityInjector, HasSupportFragmentInjector {


    public static MyApplication mInstance;
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private boolean mIsSyncManagerSetup = false;

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initializeComponent();
    }

    private void initializeComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }


    public boolean isSyncManagerSetup() {
        return mIsSyncManagerSetup;
    }

    public void setSyncManagerSetup(boolean syncManagerSetup) {
        mIsSyncManagerSetup = syncManagerSetup;
    }
}



