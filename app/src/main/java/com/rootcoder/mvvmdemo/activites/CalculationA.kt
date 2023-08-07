package com.rootcoder.mvvmdemo.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.databinding.ActivityCalculationBinding
import com.rootcoder.mvvmdemo.viewmodels.CalculationVM
import com.rootcoder.mvvmdemo.viewmodelfactory.CalculationVMF

class CalculationA : AppCompatActivity() {

    lateinit var binding:ActivityCalculationBinding;
    lateinit var viewModel: CalculationVM;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_calculation)

        initViewModel()
        initAction()
    }

    private fun initAction() {
        binding.btnAdd.setOnClickListener(View.OnClickListener {
            viewModel.incrementOpertation()
            setCounterTv()
        })

    }

    private fun initViewModel() {
//        viewModel=ViewModelProvider(this).get(CalculationVM::class.java)
        viewModel=ViewModelProvider(this, CalculationVMF(5)).get(CalculationVM::class.java)
        setCounterTv()
    }

    private fun setCounterTv() {
        binding.tvCount.setText(viewModel.count.toString())
    }
}