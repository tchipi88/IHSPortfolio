package com.ihs.appli.portfolio.di.builder;



import com.ihs.appli.portfolio.ui.fragment.SettingsFragment;
import com.ihs.appli.portfolio.ui.fragment.SiteAddFragment;
import com.ihs.appli.portfolio.ui.fragment.SiteEditFragment;
import com.ihs.appli.portfolio.ui.fragment.SiteFragment;
import com.ihs.appli.portfolio.ui.fragment.SiteListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentBuilderModule {


    @ContributesAndroidInjector
    abstract SettingsFragment settingsFragment();
    @ContributesAndroidInjector
    abstract SiteListFragment siteListFragment();
    @ContributesAndroidInjector
    abstract SiteAddFragment siteAddFragment();
    @ContributesAndroidInjector
    abstract SiteFragment siteFragment();
    @ContributesAndroidInjector
    abstract SiteEditFragment siteEditFragment();


}


