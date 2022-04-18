package com.example.belajarchapter5.MingguKedua.ViewModel

import androidx.lifecycle.ViewModel

class ClassViewModel: ViewModel() {

    var number = 0
    fun addNumber(){
        number++
    }

    override fun onCleared() {
        super.onCleared()
    }
}