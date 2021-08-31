package com.calvin.itunesearch.ui.TrackListActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.calvin.itunesearch.R;
import com.calvin.itunesearch.data.model.Track;
import com.calvin.itunesearch.di.module.GlideApp;
import com.calvin.itunesearch.ui.base.BaseActivity;

import java.util.Locale;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @description     Track detail activity
 *
 * @author          Adrian
 * @date            08/31/21
 */
public class TrackDetailActivity extends BaseActivity<TracksViewModel> {

    @BindView(R.id.toolbar)         Toolbar mToolBar;
    @BindView(R.id.textTrackName)   TextView textTrackName;
    @BindView(R.id.textTrackArtist) TextView textTrackArtist;
    @BindView(R.id.textPrice)       TextView textPrice;
    @BindView(R.id.textGenre)       TextView textGenre;
    @BindView(R.id.textDescription) TextView textDescription;
    @BindView(R.id.imageArtWork)    RoundedImageView imageArtWork;

    @Inject
    TracksViewModel tracksViewModel;

    private Track track;

    @Override
    public TracksViewModel getViewModel() {
        return tracksViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_detail);
        ButterKnife.bind(this);

        setToolBar();

        track = getIntent().getParcelableExtra("Track");

        mToolBar.setTitle(track.getTrackName()==null ? track.getCollectionName() : track.getTrackName());
        textTrackName.setText(track.getTrackName()==null ? track.getCollectionName() : track.getTrackName());
        textTrackArtist.setText(track.getArtistName());
        textPrice.setText(String.format(Locale.getDefault(), "%s %.2f", track.getCurrency(), track.getTrackPrice() == null ? track.getCollectionPrice() : track.getTrackPrice()));
        textGenre.setText(track.getPrimaryGenreName());
        textDescription.setText(track.getLongDescription() == null ? (track.getDescription() == null ? " " : Html.fromHtml(track.getDescription())) : track.getLongDescription());

        GlideApp.with(this)
                .load(track.getArtworkUrl100())
                .into(imageArtWork);
    }

    /**
     * Method to setup the {@link Toolbar} widget and handle it's navigation
     */
    private void setToolBar(){
        setSupportActionBar(mToolBar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        mToolBar.setNavigationOnClickListener(v -> onBackPressed());
    }

}
