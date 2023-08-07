package com.rootcoder.mvvmdemo.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.viewmodels.DataBindingVM

class DataBindingVMF(var title:String,var message:String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataBindingVM(title,message) as T
    }
}