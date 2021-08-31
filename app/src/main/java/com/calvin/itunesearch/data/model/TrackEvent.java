package com.calvin.itunesearch.data.model;

/**
 * @description     Event class for track selecting
 *
 * @author          Adrian
 * @date            08/29/21
 */
public class TrackEvent {
    private Track track;

    public TrackEvent(Track track) {
       this.track = track;
    }
    public Track getTrack() {
        return track;
    }
}
