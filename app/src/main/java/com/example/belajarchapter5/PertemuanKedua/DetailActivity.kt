package com.example.belajarchapter5.PertemuanKedua

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.PertemuanKedua.Network.ApiClient
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.detail_data.*
import kotlinx.android.synthetic.main.detail_data.img_detail
import kotlinx.android.synthetic.main.detail_data.text_detailjudu
import kotlinx.android.synthetic.main.detail_data.text_detailsutradara
import kotlinx.android.synthetic.main.detail_data.text_detailtgl
import kotlinx.android.synthetic.main.item_filem.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailfilm = intent.getParcelableExtra<GetAllFilmResponseItem>("detaifilm")
        text_detailjudu.text = detailfilm?.name
        text_detailtgl.text = detailfilm?.date
        text_detailsutradara.text = detailfilm?.director
        text_detaildescrip.text = detailfilm?.description
        //get data dan menampilkan gambar
        Glide.with(applicationContext).load(detailfilm?.image).into(img_detail)

        tombol_hapus.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("HAPUS DATA")
                .setMessage("Yakin hapus data ?")
                .setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                    deleteDataFilm(detailfilm?.id!!.toInt())
                    finish()
                }
                .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                .show()
        }

        tombol_edit.setOnClickListener {
            val pindah = Intent(this, UpdateFilmActivity::class.java)
            pindah.putExtra("updateFilm", detailfilm)
            startActivity(pindah)
        }

    }

    fun deleteDataFilm(id : Int){
        ApiClient.instance.deleteFilm(id)
            .enqueue(object : Callback<Int>{
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@DetailActivity, "SUCCESS", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@DetailActivity, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Toast.makeText(this@DetailActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}