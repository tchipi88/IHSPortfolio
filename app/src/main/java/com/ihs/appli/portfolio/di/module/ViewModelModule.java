package com.ihs.appli.portfolio.di.module;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ihs.appli.portfolio.ui.viewmodel.SiteViewModel;
import com.ihs.appli.portfolio.ui.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;



@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SiteViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsSiteViewModel(SiteViewModel siteViewModel);


    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
