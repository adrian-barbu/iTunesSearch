package com.calvin.itunesearch.ui.TrackListActivity;

import android.app.Application;

import com.calvin.itunesearch.data.DataManager;
import com.calvin.itunesearch.ui.adapter.TrackListAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class TrackListModule {

    @Provides
    TracksViewModel provideTracksViewModel(Application application , DataManager dataManager) {
        return new TracksViewModel(application , dataManager);
    }


    @Provides
    TrackListAdapter provideTrackListAdapter(){
        return new TrackListAdapter(new ArrayList<>());
    }
}
