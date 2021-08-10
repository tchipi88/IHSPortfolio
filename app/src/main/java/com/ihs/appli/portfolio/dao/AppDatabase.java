package com.ihs.appli.portfolio.dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ihs.appli.portfolio.domain.Site;
import com.ihs.appli.portfolio.util.IHSConstants;

import java.util.concurrent.Executors;



@Database(entities = {Site.class}, version = IHSConstants.DATABASE_VERSION)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;


    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, IHSConstants.DATABASE_NAME)
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            //TODO remove
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Executors.newSingleThreadScheduledExecutor().execute(() -> {
                                        INSTANCE.siteDao().insertAll(Site.readData(context));
                                    });
                                }
                            })
                            .build();
        }
        return INSTANCE;
    }


    public abstract SiteDao siteDao();



}