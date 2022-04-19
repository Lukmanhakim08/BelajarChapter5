package com.example.belajarchapter5.MingguKedua.Senin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelDua : ViewModel() {
    var angka = 0

    val addNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val lesNumber : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}