package com.rootcoder.mvvmdemo.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.viewmodels.CalculationVM

class CalculationVMF(var counter:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CalculationVM(counter) as T
    }
}