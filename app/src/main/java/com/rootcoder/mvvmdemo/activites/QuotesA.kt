package com.rootcoder.mvvmdemo.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.databinding.ActivityQuotesBinding
import com.rootcoder.mvvmdemo.viewmodels.QuotesVM
import com.rootcoder.mvvmdemo.viewmodelfactory.QuotesVMF

class QuotesA : AppCompatActivity() {

    lateinit var binding:ActivityQuotesBinding
    lateinit var viewModel:QuotesVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_quotes)


        initControl()
        initAction()

    }

    private fun initAction() {
        binding.tvNext.setOnClickListener {
            viewModel.incrementQuote()
            showQuotesList()
        }

        binding.tvPrevious.setOnClickListener {
            viewModel.decrementQuote()
            showQuotesList()
        }
    }

    private fun initControl() {
//        viewModel=ViewModelProvider(this).get(QuotesVM::class.java);
        viewModel=ViewModelProvider(this, QuotesVMF(this)).get(QuotesVM::class.java);

        setupQuotesList()
    }

    private fun setupQuotesList() {
//        viewModel.initDefaultList()
        viewModel.initJSONList()
        showQuotesList()
    }

    private fun showQuotesList() {
        if (viewModel.quotesList.size>0)
        {
            binding.tvQuotes.setText(viewModel.quotesList.get(viewModel.currentIndex).text)
            binding.tvAurther.setText(viewModel.quotesList.get(viewModel.currentIndex).author)
        }

    }
}