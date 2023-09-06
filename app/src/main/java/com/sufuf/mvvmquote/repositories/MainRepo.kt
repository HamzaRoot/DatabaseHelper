package com.sufuf.mvvmquote.repositories

import androidx.lifecycle.LiveData
import com.sufuf.mvvmquote.roomdatabase.QuoteDAO
import com.sufuf.mvvmquote.roomdatabase.QuoteDM


//we create dao object here because repo interact room and apis i this case we get data from roomdb so we pass dao here
class MainRepo(private val quoteDao:QuoteDAO) {

    fun getQuotes():LiveData<List<QuoteDM>>{
        return quoteDao.getQuotes()
    }

    suspend fun getRandomQuote():QuoteDM{
        return quoteDao.getRandoQuote()
    }

    suspend fun insertQuote(model:QuoteDM)
    {
        quoteDao.insertQuote(model)
    }
}