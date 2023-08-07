package com.rootcoder.mvvmdemo.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.databinding.ActivityDataBindingBinding
import com.rootcoder.mvvmdemo.datamodels.DataBindingDM
import com.rootcoder.mvvmdemo.viewmodelfactory.DataBindingVMF
import com.rootcoder.mvvmdemo.viewmodels.DataBindingVM

class DataBindingA : AppCompatActivity() {

    lateinit var binding:ActivityDataBindingBinding
    lateinit var viewModel:DataBindingVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_data_binding)

        viewModel=ViewModelProvider(this, DataBindingVMF("Title","Message")).get(DataBindingVM::class.java)
        binding.model=viewModel
        binding.lifecycleOwner=this
    }


}