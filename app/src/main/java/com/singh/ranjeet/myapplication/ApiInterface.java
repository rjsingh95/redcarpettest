package com.singh.ranjeet.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface ApiInterface {
    @GET("v0/topstories.json?print=pretty")
    Call<List<Integer>> getTopStories();
    @GET("v0/item/{articleid}.json?print=pretty")
    Call<model> getArticle(@Path("articleid") int id);
}
