package com.ihs.appli.portfolio.dao.repository;

import androidx.lifecycle.LiveData;

import com.ihs.appli.portfolio.dao.SiteDao;
import com.ihs.appli.portfolio.domain.Site;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;



public class SiteRepository {

    final private SiteDao dao;
    final private Executor executor;

    @Inject
    public SiteRepository(SiteDao dao, Executor executor) {
        this.dao = dao;
        this.executor = executor;
    }

    public LiveData<List<Site>> loadSites() {
        return dao.getAll();
    }

    public LiveData<List<Site>> loadSites(String searchText) {
        return dao.getAll(searchText);
    }


    public void insert(Site site) {
        dao.insert(site);
    }
}
