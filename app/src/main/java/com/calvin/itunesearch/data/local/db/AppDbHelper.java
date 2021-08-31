package com.calvin.itunesearch.data.local.db;

import android.util.Log;

import com.calvin.itunesearch.data.model.Track;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * @description     Define DB Helper
 *
 * @author          Adrian
 * @date            08/28/21
 */
@Singleton
public class AppDbHelper implements DbHelper{

    private static final String TAG = AppDbHelper.class.getSimpleName();

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<Boolean> saveTracks(List<Track> tracks) {
        return Observable.fromCallable(() -> {
            try{
                mAppDatabase.trackDao().insertAll(tracks);
                return true;
            }catch (Exception e){
                Log.d(TAG , e.getMessage());
            }

            return false;
        });
    }

    @Override
    public Observable<List<Track>> searchTrack(String term) {
        return Observable.fromCallable(() -> mAppDatabase.trackDao().searchTrack(term));
    }

    @Override
    public Observable<List<Track>> loadAllTracks() {
        return Observable.fromCallable(() -> mAppDatabase.trackDao().loadAll());
    }
}
