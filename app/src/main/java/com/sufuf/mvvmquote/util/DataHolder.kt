package com.sufuf.mvvmquote.util

import androidx.lifecycle.MutableLiveData

object DataHolder {
    private val _sharedData = MutableLiveData<String>()

    val sharedData: MutableLiveData<String>
        get() = _sharedData

    fun updateSharedData(newData: String) {
        _sharedData.value = newData
    }
}