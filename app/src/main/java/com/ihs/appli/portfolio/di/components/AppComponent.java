package com.ihs.appli.portfolio.di.components;


import android.app.Application;

import com.ihs.appli.portfolio.MyApplication;
import com.ihs.appli.portfolio.di.builder.ActivityBuilderModule;
import com.ihs.appli.portfolio.di.module.AppModule;
import com.ihs.appli.portfolio.di.module.DaoModule;
import com.ihs.appli.portfolio.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(
        modules = {AndroidSupportInjectionModule.class,
                AppModule.class,
                ActivityBuilderModule.class,
                RepositoryModule.class,
                DaoModule.class}
)
public interface AppComponent {


    void inject(MyApplication htaApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


}