package com.lucassimoesmartins.myretrofitexample.data

import com.lucassimoesmartins.myretrofitexample.constants.Constants
import com.lucassimoesmartins.myretrofitexample.model.PopularMovies
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("movie/popular?api_key=${Constants.API_KEY}")
    fun getPopularMovies() : Call<PopularMovies>
}