package com.example.tv_film_taufan.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tv_film_taufan.models.TvShowItem
import com.example.tv_film_taufan.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject
constructor(private val repository: TvShowRepository) : ViewModel() {

    private val _response = MutableLiveData<List<TvShowItem>>()
    val responseTvShow: LiveData<List<TvShowItem>>
        get() = _response

    init {
        //mendapatkan informasi dari server
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let {response ->
            //jika view model berhasil maka akan memberikan respon
            //jika tidak berhasil maka akan menampilkan sebuah pesan
            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("tag", "getAllTvShows Error: ${response.code()}")
            }
        }
    }



}
