package com.rootcoder.mvvmdemo.viewmodels

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.drawee.view.SimpleDraweeView
import com.rootcoder.globalizegym.helpingclasses.Helper
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.datamodels.BindingAdapterDM
import com.rootcoder.mvvmdemo.datamodels.DataBindingDM

class BindingAdapterVM(var name:String,var url:String): ViewModel() {

    private var editableModel= MutableLiveData<BindingAdapterDM>(BindingAdapterDM(name,url))

    val liveData: LiveData<BindingAdapterDM>
        get()=editableModel


}

