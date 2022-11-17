package com.example.tv_film_taufan.api

import com.example.tv_film_taufan.helper.Constants
import com.example.tv_film_taufan.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
//meminta respoonse pada tvshowresponse
    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>

}