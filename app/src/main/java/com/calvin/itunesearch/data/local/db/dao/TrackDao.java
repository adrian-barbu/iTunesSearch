package com.calvin.itunesearch.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.calvin.itunesearch.data.model.Track;

import java.util.List;

/**
 * @description     Define TAO for tracks
 *
 * @author          Adrian
 * @date            08/28/21
 */
@Dao
public interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Track> tracks);

    @Query("SELECT * FROM tracks")
    List<Track> loadAll();

    @Query("SELECT * FROM tracks WHERE trackName LIKE '%' || :term || '%'")
    List<Track> searchTrack(String term);
}
