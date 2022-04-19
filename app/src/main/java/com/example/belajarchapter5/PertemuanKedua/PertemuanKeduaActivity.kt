package com.example.belajarchapter5.PertemuanKedua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarchapter5.PertemuanKedua.Adapter.AdapterFilm
import com.example.belajarchapter5.PertemuanKedua.Adapter.AdapterUser
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllUserItem
import com.example.belajarchapter5.PertemuanKedua.Network.ApiClient
import com.example.belajarchapter5.PertemuanKedua.vm.ViewModelFilm
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_pertemuan_kedua.*
import retrofit2.Call
import retrofit2.Response

class PertemuanKeduaActivity : AppCompatActivity() {

    lateinit var adapterFilm: AdapterFilm
//    lateinit var datafilm : List<GetAllFilmResponseItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertemuan_kedua)

        initrecyler()
        getDatFilm()

        fab_add.setOnClickListener {
            val pind = Intent(this, AddfilmActivity::class.java)
            startActivity(pind)
        }

        getDataUser()
    }
    fun initrecyler(){
        rv_film.layoutManager =LinearLayoutManager(this)
        adapterFilm = AdapterFilm(){}
        rv_film.adapter = adapterFilm
    }

    fun getDatFilm(){
        val vieModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        vieModel.getLiveFilmObserver().observe(this, Observer {
            if(it != null){
                adapterFilm.setdataFilm(it)
                adapterFilm.notifyDataSetChanged()
            }
        })
        vieModel.makeApifilm()
    }

//    fun getDataFilm(){
//        ApiClient.instance.getAllFilm()
//            .enqueue(object : retrofit2.Callback<List<GetAllFilmResponseItem>>{
//                override fun onResponse(
//                    call: Call<List<GetAllFilmResponseItem>>,
//                    response: Response<List<GetAllFilmResponseItem>>
//                ) {
//                    if (response.isSuccessful){
//                        val datafilm = response.body()
//                        val adapterFilm = AdapterFilm(datafilm!!){
//                            val pindah = Intent(this@PertemuanKeduaActivity, DetailActivity::class.java)
//                            pindah.putExtra("detaifilm", it)
//                            startActivity(pindah)
//                        }
//                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//                        rv_film.layoutManager = lm
//                        rv_film.adapter = adapterFilm
//                    }else{
//                        Toast.makeText(this@PertemuanKeduaActivity, response.message(), Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
//                    Toast.makeText(this@PertemuanKeduaActivity, t.message, Toast.LENGTH_SHORT).show()
//                }
//
//            })
//    }

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

    override fun onResume() {
        super.onResume()
//        getDataFilm()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}