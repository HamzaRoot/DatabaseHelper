package com.sufuf.mvvmquote.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sufuf.mvvmquote.repositories.MainRepo
import com.sufuf.mvvmquote.roomdatabase.QuoteDM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//view model always interact with repo
class QuoteVM(private val repo:MainRepo) : ViewModel() {

    private var mutableLiveData= MutableLiveData<Quote>()
    val liveData:LiveData<Quote>
        get()=mutableLiveData

    fun getRandomQuotes() {
        viewModelScope.launch() {
            val quote=Quote(repo.getRandomQuote().id,repo.getRandomQuote().text,repo.getRandomQuote().author)
            mutableLiveData.value=quote

            Log.d("TestETs",liveData.value.toString())
        }
    }

    fun inserQuote(){
        viewModelScope.launch(Dispatchers.IO){
            repo.insertQuote(repo.getRandomQuote().copy(id=0))

            Log.d("TestETs",liveData.value.toString())
        }
    }

}