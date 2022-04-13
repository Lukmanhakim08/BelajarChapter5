package com.example.belajarchapter5.PertemuanKedua.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RequestFilm(
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("name")
    val name: String

): Parcelable
