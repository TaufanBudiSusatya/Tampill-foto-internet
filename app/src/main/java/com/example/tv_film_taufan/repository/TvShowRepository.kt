package com.example.tv_film_taufan.repository

import com.example.tv_film_taufan.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject

//mendapatkan api service dengan gettvshows
constructor(private val apiService: ApiService) {
    suspend fun getTvShows() = apiService.getTvShows()
}