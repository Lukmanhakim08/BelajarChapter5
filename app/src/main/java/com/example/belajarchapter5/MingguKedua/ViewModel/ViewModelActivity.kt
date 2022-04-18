package com.example.belajarchapter5.MingguKedua.ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity(), LifecycleOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

//        var nomor = 0
        var viewModel = ViewModelProvider(this).get(ClassViewModel::class.java)

        text_nilai.text = viewModel.number.toString()

        btn_tambah.setOnClickListener {
//            nomor++
//            text_nilai.text = nomor.toString()
            viewModel.addNumber()
            text_nilai.text = viewModel.number.toString()
        }
    }
}