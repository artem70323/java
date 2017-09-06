package com.gmail.androiddz.data.net;

import com.gmail.androiddz.data.entity.ProfileData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestApi {

    @GET("data/profile")
    Observable<List<ProfileData>> getProfiles();

    @GET("data/profile/{id}")
    Observable<ProfileData> getProfile(@Path("id") String id);

    @POST("data/profile")
    Observable<Void> saveProfile(@Body ProfileData profile);

    @PUT("data/profile/{id}")
    Observable<ProfileData> overwriteProfile(@Body ProfileData profile, @Path("id") String id);
}