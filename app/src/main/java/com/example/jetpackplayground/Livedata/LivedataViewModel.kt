package com.example.jetpackplayground.Livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LivedataViewModel :ViewModel(){


    private var _testMutableLiveData = MutableLiveData(0)
    val testLiveData: LiveData<Int>
        get() = _testMutableLiveData

    fun plusLiveDataValue() {
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }
}