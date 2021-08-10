package com.ihs.appli.portfolio.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ihs.appli.portfolio.domain.Site;

import java.util.List;


@Dao
public interface SiteDao {

    @Insert
    void insert(Site Site);


    @Query("SELECT * FROM Site")
    LiveData<List<Site>> getAll();

    @Query("SELECT * FROM Site s where s.name like :searchtext")
    LiveData<List<Site>> getAll(String searchtext);


    @Insert
    void insertAll(Site... dataEntities);
}
