package com.example.belajarchapter5.PertemuanKedua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.belajarchapter5.PertemuanKedua.Model.RequestFilm
import com.example.belajarchapter5.PertemuanKedua.Model.addDataFilmResponse
import com.example.belajarchapter5.PertemuanKedua.Network.ApiClient
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_addfilm.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddfilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addfilm)

        btn_save.setOnClickListener {
            val desc = edt_descriptio.text.toString()
            val direct = edt_director.text.toString()
            val img = edt_imgfilm.text.toString()
            val name = edt_judul.text.toString()
            postDataFilm(desc, direct, img, name)
            finish()
        }
    }

    fun postDataFilm(desc: String, direct:String, img:String, name:String){
        ApiClient.instance.addDataFilm(RequestFilm(desc, direct, img, name))
            .enqueue(object : Callback<addDataFilmResponse>{
                override fun onResponse(
                    call: Call<addDataFilmResponse>,
                    response: Response<addDataFilmResponse>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@AddfilmActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@AddfilmActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<addDataFilmResponse>, t: Throwable) {
                    Toast.makeText(this@AddfilmActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}