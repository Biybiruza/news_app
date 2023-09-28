package com.biybiruza.news.networking;

import com.biybiruza.news.data.Models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("everything?domains=wsj.com&apiKey=74c6de7f96f349a8ac1e22dfe234437c")
    Call<Models> getNewsList();
}
