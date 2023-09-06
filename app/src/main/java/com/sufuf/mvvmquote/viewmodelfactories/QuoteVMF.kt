package com.sufuf.mvvmquote.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sufuf.mvvmquote.repositories.MainRepo
import com.sufuf.mvvmquote.viewmodels.QuoteVM

class QuoteVMF(private val repo: MainRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteVM(repo) as T
    }
}