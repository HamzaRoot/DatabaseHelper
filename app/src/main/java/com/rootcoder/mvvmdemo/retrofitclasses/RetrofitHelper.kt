package com.rootcoder.mvvmdemo.retrofitclasses

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
//    val BASE_URL:String="https://m9.elecqueue.com"
//val BASE_URL:String="https://reqres.in/"
    val BASE_URL:String="https://betaapi.elecqueue.com"


    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}