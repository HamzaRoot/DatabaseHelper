package com.rootcoder.mvvmdemo.retrofitclasses.apiinterfaces


import com.rootcoder.mvvmdemo.retrofitclasses.amenitiesmodel.AmenitiesPostModel
import com.rootcoder.mvvmdemo.retrofitclasses.models.CommonDataModel
import com.rootcoder.mvvmdemo.retrofitclasses.postmodel.PostRequestModel
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiCallInterfaces {



    @GET("/Api/Transportation/CommonData/GetALL")
    suspend fun getCommonData(@HeaderMap headers:HashMap<String, String>):Response<CommonDataModel>



    @POST("api/register")
    suspend fun getRegisterData(@Body body: RequestBody):Response<PostRequestModel>

    @POST("/Api/Istraha/GetByLocation")
    suspend fun getAmenitiesData(@HeaderMap headers:HashMap<String, String>,@Body body: String):Response<AmenitiesPostModel>
}