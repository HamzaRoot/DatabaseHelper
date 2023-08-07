package com.rootcoder.mvvmdemo.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.viewmodels.QuotesVM

class QuotesVMF(val context:Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesVM(context) as T
    }
}