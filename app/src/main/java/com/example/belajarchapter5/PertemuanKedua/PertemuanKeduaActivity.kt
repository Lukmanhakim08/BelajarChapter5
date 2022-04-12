package com.example.belajarchapter5.PertemuanKedua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarchapter5.PertemuanKedua.Adapter.AdapterFilm
import com.example.belajarchapter5.PertemuanKedua.Adapter.AdapterUser
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllUserItem
import com.example.belajarchapter5.PertemuanKedua.Network.ApiClient
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_pertemuan_kedua.*
import retrofit2.Call
import retrofit2.Response

class PertemuanKeduaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertemuan_kedua)

        getDataFilm()
        getDataUser()
    }

    fun getDataFilm(){
        ApiClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val datafilm = response.body()
                        val adapterFilm = AdapterFilm(datafilm!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_film.layoutManager = lm
                        rv_film.adapter = adapterFilm
                    }else{
                        Toast.makeText(this@PertemuanKeduaActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@PertemuanKeduaActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }

    fun getDataUser(){
        ApiClient.instance.getAllUser()
            .enqueue(object : retrofit2.Callback<List<GetAllUserItem>>{
                override fun onResponse(
                    call: Call<List<GetAllUserItem>>,
                    response: Response<List<GetAllUserItem>>
                ) {
                    if (response.isSuccessful){
                        val datauser = response.body()
                        val adapterUser = AdapterUser(datauser!!)
                        val ab = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_user.layoutManager = ab
                        rv_user.adapter = adapterUser
                    }else{
                        Toast.makeText(this@PertemuanKeduaActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllUserItem>>, t: Throwable) {
                    Toast.makeText(this@PertemuanKeduaActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}