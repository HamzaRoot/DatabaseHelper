package com.rootcoder.mvvmdemo.viewmodels

import androidx.lifecycle.ViewModel

class CalculationVM(var count:Int): ViewModel() {

    fun incrementOpertation(){
        ++count
    }
}