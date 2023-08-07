package com.rootcoder.mvvmdemo.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.rootcoder.mvvmdemo.datamodels.QuotesDM
import java.util.ArrayList

class QuotesVM(val context:Context) : ViewModel() {
    var quotesList:ArrayList<QuotesDM> = ArrayList<QuotesDM>()
    var currentIndex:Int=0

    fun addQuotesToList(quote:String,aurther:String)
    {
        val model:QuotesDM=QuotesDM(quote,aurther);
        quotesList.add(model)
    }

    fun initJSONList(){
        val inputStream=context.assets.open("quotes.json")
        val size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        val json= String(buffer,Charsets.UTF_8)
        quotesList.clear()
        quotesList.addAll(Gson().fromJson(json,Array<QuotesDM>::class.java))
    }

    fun initDefaultList(){
        quotesList.clear()
        addQuotesToList("The greatest glory in living lies not in never falling, but in rising every time we fall.","Nelson Mandela")
        addQuotesToList("The way to get started is to quit talking and begin doing.","Walt Disney")
        addQuotesToList("If life were predictable it would cease to be life, and be without flavor.","Eleanor Roosevelt")
        addQuotesToList("Life is what happens when you're busy making other plans.","John Lennon")
    }

    fun incrementQuote(){
        if (currentIndex<(quotesList.size-1))
        {
            ++currentIndex
        }
    }

    fun decrementQuote(){
        if (currentIndex>0)
        {
            --currentIndex
        }
    }
}