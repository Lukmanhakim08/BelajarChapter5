package com.example.belajarchapter5.PertemuanKedua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.PertemuanKedua.Model.RequestFilm
import com.example.belajarchapter5.PertemuanKedua.Network.ApiClient
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_addfilm.*
import kotlinx.android.synthetic.main.activity_update_film.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_film)

        val getFilm = intent.getParcelableExtra<GetAllFilmResponseItem>("updateFilm")
        edit_judul.setText(getFilm?.name)
        edit_director.setText(getFilm?.director)
        edit_imgfilm.setText(getFilm?.image)
        edit_descriptio.setText(getFilm?.description)

        btn_update.setOnClickListener {
            val id = getFilm?.id
            val name = edit_judul.text.toString()
            val image = edit_imgfilm.text.toString()
            val director = edit_director.text.toString()
            val description = edit_descriptio.text.toString()
            updateDataFilm(id!!.toInt(), description, director, image, name)
            finish()
        }
    }

    fun updateDataFilm(id :Int, name: String, img: String, desc: String, direct: String){
        ApiClient.instance.updateFilm(id, RequestFilm(desc, direct, img, name))
            .enqueue(object : Callback<List<GetAllFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllFilmResponseItem>>,
                    response: Response<List<GetAllFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@UpdateFilmActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@UpdateFilmActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllFilmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@UpdateFilmActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}