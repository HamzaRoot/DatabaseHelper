package com.rootcoder.mvvmdemo.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.databinding.ActivityHomeBinding

class HomeA : AppCompatActivity() {

    lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)

        initControl()

    }

    private fun initControl() {
        binding.btnCalculation.setOnClickListener {
            val intent=Intent(this,CalculationA::class.java)
            startActivity(intent)
        }
        binding.btnQuetes.setOnClickListener {
            val intent=Intent(this,QuotesA::class.java)
            startActivity(intent)
        }
        binding.btnMutableLivedata.setOnClickListener {
            val intent=Intent(this,MutableLiveDataA::class.java)
            startActivity(intent)
        }
        binding.btnDatabinding.setOnClickListener {
            val intent=Intent(this,DataBindingA::class.java)
            startActivity(intent)
        }
        binding.btnBindingAdapter.setOnClickListener {
            val intent=Intent(this,BindingAdapterA::class.java)
            startActivity(intent)
        }
        binding.btnRoomDatabase.setOnClickListener {
            val intent=Intent(this,RoomDatabaseA::class.java)
            startActivity(intent)
        }

        binding.btnRetrofit.setOnClickListener {
            val intent=Intent(this,RetrofitA::class.java)
            startActivity(intent)
        }


    }
}