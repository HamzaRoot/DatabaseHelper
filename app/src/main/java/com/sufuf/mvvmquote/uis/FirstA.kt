package com.sufuf.mvvmquote.uis

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.sufuf.mvvmquote.R
import com.sufuf.mvvmquote.databinding.ActivityFirstBinding
import com.sufuf.mvvmquote.util.DataHolder

class FirstA : AppCompatActivity() {

    lateinit var binding:ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_first)

        initControl()
    }

    private fun initControl() {
        binding.btnNext.setOnClickListener {
            binding.tvTitle.text="Next"
            val callIntent= Intent(binding.root.context,SecondA::class.java)
            resultCallback.launch(callIntent)
        }

        DataHolder.sharedData.observe(this, { newData ->
            binding.tvTitle.text = newData
        })
    }


    val resultCallback = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.let {
                if (it.getBooleanExtra("isShow",false))
                {
                    binding.tvTitle.text=it.getStringExtra("title")
                }
            }
        }
    }




}