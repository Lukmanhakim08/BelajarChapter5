package com.example.belajarchapter5.MingguKedua.Senin.LifeData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belajarchapter5.MingguKedua.Senin.ViewModel.ViewModelDua
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_life_data.*

class LifeDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_data)

        val vieModels = ViewModelProvider(this).get(ViewModelDua::class.java)

//        text_angkass.text = it.toString()
        vieModels.addNumber.observe(this, Observer {
            text_angkass.text = it.toString()
//            vieModels.addNumber.value = it
        })

        vieModels.lesNumber.observe(this, Observer {
            text_angkass.text = it.toString()
//            vieModels.addNumber.value = it
        })

        btn_plusss.setOnClickListener {
            vieModels.addNumber.observe(this, Observer {
                vieModels.addNumber.value = ++vieModels.angka
                text_angkass.text = vieModels.angka.toString()
            })
        }

        btn_minusss.setOnClickListener {
            vieModels.lesNumber.observe(this, Observer {
                vieModels.lesNumber.value = --vieModels.angka
                text_angkass.text = vieModels.angka.toString()
            })
        }
    }
}