package com.calvin.itunesearch.ui.TrackListActivity;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.calvin.itunesearch.data.DataManager;
import com.calvin.itunesearch.data.model.Track;
import com.calvin.itunesearch.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @description     View model for activity
 *
 * @author          Adrian
 * @date            08/30/21
 */
public class TracksViewModel extends BaseViewModel {

    private static final String TAG = TracksViewModel.class.getSimpleName();

    MutableLiveData<List<Track>> tracksLiveData;
    MutableLiveData<Track> selectedTrack;

    @Inject
    public TracksViewModel(Application context, DataManager dataManager) {
        super(context, dataManager);
    }

    /**
     * fetch tracks from server OR local database based on sort type
     *
     * if internet available then load tracks from server and update database
     * else fetch tracks from database
     *
     * @param
     */
    void fetchTrackList(String term, String country, String media) {
        if(isNetworkConnected()) {
            fetchTracksFromServer(term, country, media);
        } else {
            fetchTracksFromDB(term, country, media);
        }
    }

    /**
     * fetch tracks from local database
     *
     * @param
     */
    private void fetchTracksFromDB(String term, String country, String media) {
        getCompositeDisposable().add(getDataManager().searchTrack(term)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trackList -> {
                    // notify subscribers about the loaded data
                    tracksLiveData.setValue(new ArrayList<>(trackList));
                } , throwable -> {
                    // notify subscribers about the error msg
                    getErrorMsg().setValue(throwable.getMessage());
                }));
    }

    /**
     * fetch tracks from remote server
     *
     * @param
     */
    private void fetchTracksFromServer(String term, String country, String media) {
        // show loading
        showLoading.call();

        getCompositeDisposable().add(getDataManager().searchTracks(term, country, media)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response->{
                    // hide loading dialog
                    hideLoading.call();

                    // update tracks in db
                    insertTracks(response.getResults());

                    // notify subscribers about the new loaded data
                    tracksLiveData.setValue(response.getResults());

                } , throwable -> {
                    // hide loading dialog
                    hideLoading.call();

                    // notify subscribers about the error msg
                    getErrorMsg().setValue(throwable.getMessage());
                }));
    }

    /**
     * insert tracks in database
     *
     * @param tracks
     */
    private void insertTracks(List<Track>tracks){
        getCompositeDisposable().add(getDataManager().saveTracks(tracks)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response->{
                    Log.d(TAG , tracks.size()+" tracks inserted in db");
                } , throwable -> {
                    Log.d(TAG , "error inserting tracks : " +throwable.getMessage());
                }));
    }


    public MutableLiveData<List<Track>> getTracksLiveData() {
        if(tracksLiveData ==null)
            tracksLiveData = new MutableLiveData<>();
        return tracksLiveData;
    }

    public void getTrackLiveData(int trackId) {
        if(tracksLiveData == null)
            return;

        ArrayList<Track> tracks = (ArrayList<Track>) tracksLiveData.getValue();
        for (Track track: tracks) {
            if (track.getTrackId() == trackId) {
                selectedTrack.setValue(track);
                return;
            }
        }
    }

}
