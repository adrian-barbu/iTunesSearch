package com.calvin.itunesearch.ui.TrackListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

import com.calvin.itunesearch.R;
import com.calvin.itunesearch.data.model.TrackEvent;
import com.calvin.itunesearch.ui.adapter.TrackListAdapter;
import com.calvin.itunesearch.ui.base.BaseActivity;
import com.calvin.itunesearch.utils.CommonUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;

/**
 * @description     Main activity with track search features
 *
 * @author          Adrian
 * @date            08/30/21
 */
public class TrackListActivity extends BaseActivity<TracksViewModel>{

    @BindView(R.id.rv_tracks)   RecyclerView rv_tracks;
    @BindView(R.id.et_key)      EditText etKey;

    @Inject
    TracksViewModel tracksViewModel;

    @Inject
    TrackListAdapter trackListAdapter;

    @Override
    public TracksViewModel getViewModel() {
        return tracksViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);
        ButterKnife.bind(this);

        // initialize recycler view
        setupTracksRecyclerView();

        // subscribe to live data changes
        tracksViewModel.getTracksLiveData().observe(this, tracks -> {
            if(tracks!=null)
               trackListAdapter.addItems(new ArrayList<>(tracks));
        });
    }

    private void setupTracksRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        rv_tracks.setLayoutManager(mLayoutManager);
        rv_tracks.setAdapter(trackListAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(TrackEvent trackEvent) {
        Intent intent = new Intent(this, TrackDetailActivity.class);
        intent.putExtra("Track", trackEvent.getTrack());
        startActivity(intent);
    }

    /**
     * Binded action for the search {@link EditText} widget
     * Call attemptSearch method after user hits the search button in the SoftKeyboard
     *
     * @param actionId The actionId returned by the listener. Only proceeds if value is EditorInfo.IME_ACTION_SEARCH
     * @return The result if the search action is handled
     */
    @OnEditorAction(R.id.et_key)
    public boolean onEditorAction(int actionId){
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            doSearch();
            return true;
        }
        return false;
    }

    /**
     * Search with terms
     */
    private void doSearch() {
        CommonUtils.hideKeyboard(this, etKey);

        String term = etKey.getText().toString();

        if(TextUtils.isEmpty(term)) {
            Toast.makeText(this, R.string.warning_no_key, Toast.LENGTH_SHORT).show();
            return;
        }

        tracksViewModel.fetchTrackList(term, "us", "movie");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        trackListAdapter = null;

        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}