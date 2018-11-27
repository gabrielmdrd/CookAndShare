package com.esiea.cookandshare.data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RestAPI
{
    @GET("/api/vegetables/")
    Observable<List<Ingredient>> getIngredients();
}
