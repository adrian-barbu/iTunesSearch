package com.calvin.itunesearch.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.calvin.itunesearch.data.local.db.dao.TrackDao;
import com.calvin.itunesearch.data.model.Track;

/**
 * @description     Create Database
 *
 * @author          Adrian
 * @date            08/28/21
 */
@Database(entities = {Track.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TrackDao trackDao();
}