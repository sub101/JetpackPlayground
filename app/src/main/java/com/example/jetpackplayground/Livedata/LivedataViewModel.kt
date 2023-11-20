package com.example.jetpackplayground.Livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LivedataViewModel :ViewModel(){
    var testMutableLiveData = MutableLiveData(0)

    fun plusLiveDataValue(){
        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
    }
}