package com.rootcoder.mvvmdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rootcoder.mvvmdemo.datamodels.MutableLiveDataDM

class MutableLiveDataVM(val count:Int) : ViewModel() {
    private val mutableLiveData=MutableLiveData<MutableLiveDataDM>(MutableLiveDataDM(count))
    val liveData:LiveData<MutableLiveDataDM>
    get()=mutableLiveData


    fun incrementOpertation(){
        var oldModel:MutableLiveDataDM
        oldModel= mutableLiveData.value!!
        ++oldModel.count
        mutableLiveData.value=oldModel

    }
}