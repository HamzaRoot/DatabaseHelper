package com.sufuf.mvvmquote.uis

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.sufuf.mvvmquote.R
import com.sufuf.mvvmquote.databinding.ActivitySecondBinding

class SecondA : AppCompatActivity() {

    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_second)
        initControl()
    }

    private fun initControl() {
        binding.btnNext.setOnClickListener {
            val callIntent= Intent(binding.root.context,ThirdA::class.java)
            resultCallback.launch(callIntent)
            finish()
        }
    }


    val resultCallback = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.let {
                if (it.getBooleanExtra("isShow",false))
                {
                    setResult(RESULT_OK,it)
                    finish()
                }
            }
        }
    }
}