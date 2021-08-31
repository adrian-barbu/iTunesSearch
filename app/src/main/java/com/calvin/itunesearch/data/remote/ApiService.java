package com.calvin.itunesearch.data.remote;

import com.calvin.itunesearch.data.remote.api.TrackResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @description     Interface for API call
 *
 * @author          Adrian
 * @date            08/28/21
 */
public interface ApiService {

    @GET("/search")
    Observable<TrackResponse> searchTracks(
            @Query("term") String term, @Query("country") String country, @Query("media") String media);

}
