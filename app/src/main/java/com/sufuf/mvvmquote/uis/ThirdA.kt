package com.sufuf.mvvmquote.uis

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.sufuf.mvvmquote.R
import com.sufuf.mvvmquote.databinding.ActivityThirdBinding
import com.sufuf.mvvmquote.util.DataHolder

class ThirdA : AppCompatActivity() {

    lateinit var binding:ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_third)
        initControl()
    }

    private fun initControl() {
        binding.btnNext.setOnClickListener {
           moveBack()
        }
    }

    private fun moveBack() {
        val backIntent=Intent();
        backIntent.putExtra("isShow",true)
        backIntent.putExtra("title","Third")
        setResult(RESULT_OK,backIntent)
        DataHolder.updateSharedData("Third")
        finish()

    }


}