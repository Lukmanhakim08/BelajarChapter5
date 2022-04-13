package com.example.belajarchapter5.PertemuanKedua.Network

import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllUserItem
import com.example.belajarchapter5.PertemuanKedua.Model.RequestFilm
import com.example.belajarchapter5.PertemuanKedua.Model.addDataFilmResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @POST("film")
    fun addDataFilm(@Body req : RequestFilm) : Call<addDataFilmResponse>

    @GET("user")
    fun getAllUser() : Call<List<GetAllUserItem>>
}