package com.rootcoder.mvvmdemo.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.viewmodels.MutableLiveDataVM

class MutableLiveDataVMF(var count:Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MutableLiveDataVM(count) as T
    }
}