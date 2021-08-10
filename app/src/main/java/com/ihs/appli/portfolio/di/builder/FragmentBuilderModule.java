package com.ihs.appli.portfolio.di.builder;



import com.ihs.appli.portfolio.ui.fragment.SettingsFragment;
import com.ihs.appli.portfolio.ui.fragment.SiteListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentBuilderModule {


    @ContributesAndroidInjector
    abstract SettingsFragment settingsFragment();
    @ContributesAndroidInjector
    abstract SiteListFragment siteListFragment();


}


