package com.rootcoder.mvvmdemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rootcoder.mvvmdemo.datamodels.DataBindingDM

class DataBindingVM(val title:String,val message:String) : ViewModel() {
    private var editableModel=MutableLiveData<DataBindingDM>(DataBindingDM(title,message))

    val liveData:LiveData<DataBindingDM>
    get()=editableModel


    fun incrementOpertation(){
        editableModel.value=DataBindingDM("Notification Alert","Here type any kind of messsage")
    }
}