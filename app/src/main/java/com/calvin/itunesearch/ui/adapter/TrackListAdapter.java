package com.calvin.itunesearch.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.calvin.itunesearch.R;
import com.calvin.itunesearch.data.model.Track;
import com.calvin.itunesearch.data.model.TrackEvent;
import com.calvin.itunesearch.databinding.ItemListBinding;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * @description     List Adapter with tracks
 *
 * @author          Adrian
 * @date            08/30/21
 */
public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.ViewHolder> {
    Context mContext;
    LayoutInflater layoutInflater;
    public ArrayList<Track> tracks;

    public TrackListAdapter(ArrayList<Track> tracks) {
        //mContext = context;
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ItemListBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.binding.setTrack(tracks.get(position));
        viewHolder.binding.layoutItem.setOnClickListener(v -> {
            EventBus.getDefault().post(new TrackEvent(tracks.get(position)));
        });
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final ItemListBinding binding;

        public ViewHolder(ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void addItems(ArrayList<Track> tracks){
        this.tracks.clear();
        this.tracks.addAll(tracks);
        notifyDataSetChanged();
    }
}
