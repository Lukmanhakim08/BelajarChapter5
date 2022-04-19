package com.example.belajarchapter5.MingguKedua.Senin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_tanpa_view_model.*

class TanpaViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanpa_view_model)

        var angka = 0
        btn_minus.setOnClickListener {
            angka--
            text_angka.text = angka.toString()
        }

        btn_plus.setOnClickListener {
            angka ++
            text_angka.text = angka.toString()
        }
    }
}