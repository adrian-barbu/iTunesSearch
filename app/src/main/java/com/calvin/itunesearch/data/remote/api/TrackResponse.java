package com.calvin.itunesearch.data.remote.api;

import com.calvin.itunesearch.data.model.Track;

import java.util.List;

/**
 * @description     API Call
 *
 * @author          Adrian
 * @date            08/28/21
 */
public class TrackResponse {
    private List<Track> results = null;
    public List<Track> getResults() {
        return results;
    }
}
