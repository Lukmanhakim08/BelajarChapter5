package com.example.belajarchapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajarchapter5.MingguKedua.MingguKeduaActivity
import com.example.belajarchapter5.PertemuanKedua.PertemuanKeduaActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_pertemuan_kedua.setOnClickListener {
            startActivity(Intent(this, PertemuanKeduaActivity::class.java))
        }

        btn_minggu_kedua.setOnClickListener {
            startActivity(Intent(this, MingguKeduaActivity::class.java))
        }
    }
}