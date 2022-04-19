package com.example.belajarchapter5.MingguKedua.Senin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.belajarchapter5.MingguKedua.Senin.ViewModel.ViewModesatu
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_pakek_view_model.*
import kotlinx.android.synthetic.main.activity_tanpa_view_model.*

class PakekViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pakek_view_model)

        val viewModel = ViewModelProvider(this).get(ViewModesatu::class.java)

        text_angkas.text = viewModel.angka.toString()

        btn_pluss.setOnClickListener {
            ++viewModel.angka
            text_angkas.text = viewModel.angka.toString()
        }

        btn_minuss.setOnClickListener {
            --viewModel.angka
            text_angkas.text = viewModel.angka.toString()
        }

    }
}