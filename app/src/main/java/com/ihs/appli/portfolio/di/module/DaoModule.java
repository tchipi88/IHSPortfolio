package com.ihs.appli.portfolio.di.module;

import android.app.Application;

import com.ihs.appli.portfolio.dao.AppDatabase;
import com.ihs.appli.portfolio.dao.SiteDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DaoModule {
    @Provides
    @Singleton
    public SiteDao provideSiteDao(Application app) {
        AppDatabase db = AppDatabase.getAppDatabase(app);
        return db.siteDao();
    }



}