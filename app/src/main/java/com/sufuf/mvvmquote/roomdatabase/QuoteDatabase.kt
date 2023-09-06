package com.sufuf.mvvmquote.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuoteDM::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao():QuoteDAO

    companion object{

        @Volatile
        private var INSTANCE:QuoteDatabase?=null

        fun getQuoteDatabase(context:Context):QuoteDatabase
        {
            if (INSTANCE==null)
            {
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,
                    QuoteDatabase::class.java,"QuoteDb")
                        .createFromAsset("quotes.db").build()
                }
            }
            return INSTANCE!!
        }
    }
}