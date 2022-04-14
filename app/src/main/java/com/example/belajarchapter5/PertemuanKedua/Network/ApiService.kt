package com.example.belajarchapter5.PertemuanKedua.Network

import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllUserItem
import com.example.belajarchapter5.PertemuanKedua.Model.RequestFilm
import com.example.belajarchapter5.PertemuanKedua.Model.addDataFilmResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @POST("film")
    fun addDataFilm(@Body req : RequestFilm) : Call<addDataFilmResponse>

    @DELETE("film/{id}")
    fun deleteFilm(@Path ("id") id :Int): Call<Int>

    @PUT("film/{id}")
    fun updateFilm(
        @Path("id") id: Int,
        @Body reques : RequestFilm
    )
    : Call<List<GetAllFilmResponseItem>>

    @GET("user")
    fun getAllUser() : Call<List<GetAllUserItem>>
}