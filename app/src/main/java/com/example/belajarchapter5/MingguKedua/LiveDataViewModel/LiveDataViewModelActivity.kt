package com.example.belajarchapter5.MingguKedua.LiveDataViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.activity_live_data_view_model.*

class LiveDataViewModelActivity : AppCompatActivity() {

    lateinit var viewModel: TextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_view_model)

        viewModel = ViewModelProvider(this).get(TextViewModel::class.java)
        viewModel.currentNumber.observe(this, Observer {
            tv_nilain.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            text_nilain.text = it.toString()
        })

        incrementText()
    }

    private fun incrementText(){
        btn_tambahn.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }
}