package com.calvin.itunesearch.data.local.db;

import com.calvin.itunesearch.data.model.Track;

import java.util.List;
import io.reactivex.Observable;

/**
 * @description     Interface for DB Helper
 *
 * @author          Adrian
 * @date            08/28/21
 */
public interface DbHelper {
    Observable<Boolean> saveTracks(List<Track> tracks);
    Observable<List<Track>> searchTrack(String term);
    Observable<List<Track>> loadAllTracks();
}
