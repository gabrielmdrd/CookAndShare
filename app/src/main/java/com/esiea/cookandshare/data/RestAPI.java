package com.esiea.cookandshare.data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RestAPI
{
    @GET("/api/json/v1/1/search.php?s=/")
    Observable<List<Post>> getPosts();
}
