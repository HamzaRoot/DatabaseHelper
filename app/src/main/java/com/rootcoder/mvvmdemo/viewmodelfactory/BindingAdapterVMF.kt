package com.rootcoder.mvvmdemo.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.viewmodels.BindingAdapterVM

class BindingAdapterVMF(var name:String,var url:String):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BindingAdapterVM(name,url) as T
    }
}