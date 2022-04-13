package com.example.belajarchapter5.PertemuanKedua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.detail_data.*
import kotlinx.android.synthetic.main.detail_data.img_detail
import kotlinx.android.synthetic.main.detail_data.text_detailjudu
import kotlinx.android.synthetic.main.detail_data.text_detailsutradara
import kotlinx.android.synthetic.main.detail_data.text_detailtgl
import kotlinx.android.synthetic.main.item_filem.view.*

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
        Glide.with(applicationContext)
            .load(detailfilm?.image)
            .into(img_detail)
    }
}