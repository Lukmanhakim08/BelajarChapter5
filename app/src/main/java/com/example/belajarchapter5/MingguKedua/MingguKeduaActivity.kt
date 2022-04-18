package com.example.belajarchapter5.MingguKedua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajarchapter5.MingguKedua.LiveDataViewModel.LiveDataViewModelActivity
import com.example.belajarchapter5.MingguKedua.ViewModel.ViewModelActivity
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_minggu_kedua.*

class MingguKeduaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minggu_kedua)

        btn_viewmodel.setOnClickListener {
            startActivity(Intent(this, ViewModelActivity::class.java))
        }

        btn_ygkdua.setOnClickListener {
            startActivity(Intent(this, LiveDataViewModelActivity::class.java))
        }

    }
}