package com.calvin.itunesearch.di.builder;

import com.calvin.itunesearch.ui.TrackListActivity.TrackDetailActivity;
import com.calvin.itunesearch.ui.TrackListActivity.TrackListActivity;
import com.calvin.itunesearch.ui.TrackListActivity.TrackListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = TrackListModule.class)
    abstract TrackListActivity bindTrackListActivity();

    @ContributesAndroidInjector(modules = TrackListModule.class)
    abstract TrackDetailActivity bindTrackDetailActivity();

}
