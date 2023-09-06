package com.sufuf.mvvmquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sufuf.mvvmquote.databinding.ActivityMainBinding
import com.sufuf.mvvmquote.repositories.MainRepo
import com.sufuf.mvvmquote.roomdatabase.QuoteDatabase
import com.sufuf.mvvmquote.viewmodelfactories.QuoteVMF
import com.sufuf.mvvmquote.viewmodels.QuoteVM

class MainActivity : AppCompatActivity() {

    lateinit var bindig:ActivityMainBinding
    lateinit var database:QuoteDatabase
    lateinit var repo:MainRepo
    lateinit var model:QuoteVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig=DataBindingUtil.setContentView(this,R.layout.activity_main)

        database=QuoteDatabase.getQuoteDatabase(this)
        repo= MainRepo(database.getQuoteDao())
        model=ViewModelProvider(this, QuoteVMF(repo)).get(QuoteVM::class.java)

        bindig.model=model
        bindig.lifecycleOwner=this

    }
}