package com.example.belajarchapter5.PertemuanKedua.Network

import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @GET("user")
    fun getAllUser() : Call<List<GetAllUserItem>>
}