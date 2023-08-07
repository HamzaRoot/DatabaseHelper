package com.rootcoder.mvvmdemo.activites

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.databinding.ActivityMutableLiveDataBinding
import com.rootcoder.mvvmdemo.viewmodelfactory.MutableLiveDataVMF
import com.rootcoder.mvvmdemo.viewmodels.MutableLiveDataVM

class MutableLiveDataA : AppCompatActivity() {

    lateinit var binding:ActivityMutableLiveDataBinding
    lateinit var viewModel:MutableLiveDataVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_mutable_live_data)

        initControl()
        actionControl()
    }

    private fun actionControl() {
        binding.btnAdd.setOnClickListener(View.OnClickListener {
            viewModel.incrementOpertation()
        })
    }

    private fun initControl() {
        initViewModel()
    }

    private fun initViewModel() {
        viewModel=ViewModelProvider(this, MutableLiveDataVMF(0)).get(MutableLiveDataVM::class.java)

        viewModel.liveData.observe(this,{

            binding.tvCount.setText(it.count.toString())

        } )
    }



}