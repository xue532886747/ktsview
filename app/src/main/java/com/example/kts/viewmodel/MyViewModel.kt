package com.example.kts.viewmodel

import androidx.lifecycle.ViewModel

/**
 * @author 53288
 * @description
 * @date 2021/11/18
 */
class MyViewModel : ViewModel() {


    var number: Int = 0

    override fun onCleared() {
        super.onCleared()
        number = 0
    }
}