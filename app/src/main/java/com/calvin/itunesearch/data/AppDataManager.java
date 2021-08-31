package com.calvin.itunesearch.data;

import com.calvin.itunesearch.data.local.db.DbHelper;
import com.calvin.itunesearch.data.model.Track;
import com.calvin.itunesearch.data.remote.ApiService;
import com.calvin.itunesearch.data.remote.api.TrackResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 *
 * this class built to provide single point of access to application data sources ( shared Pref - Api Service )
 *
 */
@Singleton
public class AppDataManager implements DataManager {

    DbHelper mDbHelper;
    ApiService mApiService;

    @Inject
    public AppDataManager(ApiService mApiService, DbHelper mDbHelper) {
        this.mApiService = mApiService;
        this.mDbHelper = mDbHelper;
    }

    /****************************   API METHODS  **************************************/
    @Override
    public Observable<TrackResponse> searchTracks(String term, String country, String media) {
        return mApiService.searchTracks(term, country, media);
    }

    @Override
    public Observable<Boolean> saveTracks(List<Track> tracks) {
        return mDbHelper.saveTracks(tracks);
    }

    @Override
    public Observable<List<Track>> searchTrack(String term) {
        return mDbHelper.searchTrack(term);
    }

    @Override
    public Observable<List<Track>> loadAllTracks() {
        return mDbHelper.loadAllTracks();
    }
}
