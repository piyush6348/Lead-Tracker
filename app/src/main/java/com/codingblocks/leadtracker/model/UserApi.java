package com.codingblocks.leadtracker.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by piyush on 13/8/17.
 */

public interface UserApi {
    @GET("me")
    Call<User> getMe(@Header("Authorization") String authorization);

    @GET("{id}")
    Call<User> getUser(@Header("Authorization") String authorization, @Path("id") int id);

}
