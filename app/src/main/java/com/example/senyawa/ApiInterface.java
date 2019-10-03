package com.example.senyawa;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("bins/psd6l")
    Call<Unsur>getUnsure();
}
