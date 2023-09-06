package com.sufuf.mvvmquote.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDAO {

    @Query("SELECT * FROM quote")
    fun getQuotes():LiveData<List<QuoteDM>>

    @Query("SELECT * FROM quote ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandoQuote():QuoteDM

    @Insert
    suspend fun insertQuote(model:QuoteDM)
}