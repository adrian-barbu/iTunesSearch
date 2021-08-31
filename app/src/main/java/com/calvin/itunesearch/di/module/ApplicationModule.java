package com.calvin.itunesearch.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.calvin.itunesearch.data.AppDataManager;
import com.calvin.itunesearch.data.DataManager;
import com.calvin.itunesearch.data.local.db.AppDatabase;
import com.calvin.itunesearch.data.local.db.AppDbHelper;
import com.calvin.itunesearch.data.local.db.DbHelper;
import com.calvin.itunesearch.di.DatabaseInfo;
import com.calvin.itunesearch.di.PreferenceInfo;
import com.calvin.itunesearch.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApiServiceModule.class)
public class ApplicationModule {

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Application context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).build();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }


    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }
}
