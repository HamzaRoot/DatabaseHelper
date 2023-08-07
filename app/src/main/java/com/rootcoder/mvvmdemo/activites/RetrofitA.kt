package com.rootcoder.mvvmdemo.activites

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rootcoder.globalizegym.helpingclasses.Helper
import com.rootcoder.mvvmdemo.Constants
import com.rootcoder.mvvmdemo.R
import com.rootcoder.mvvmdemo.retrofitclasses.RetrofitHelper
import com.rootcoder.mvvmdemo.retrofitclasses.apiinterfaces.ApiCallInterfaces
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class RetrofitA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        val retrofit=RetrofitHelper.getRetrofit().create(ApiCallInterfaces::class.java)

//        synchronized(this){
//            GlobalScope.launch {
//                var headers = HashMap<String, String>()
//                headers["Content-Type"] = "application/json; charset=utf-8"
//                headers["lang"] = "en"
//                headers["ElqKey"] = "7e26add827e045e3bd882f19a5a6a382ce47f497b20f48afbaf155301eef3f86f8e681fcfe9040f5a2f643680c0eace5"
//                headers["AppTimeZone"] =  Helper.getCurrrentDate("zzzz").toString()
//
//                val result= retrofit.getCommonData(headers)
//
//                if (result!=null)
//                {
//                    val model =result.body()
//                    if (model!=null)
//                    {
//                        Log.d(Constants.tag,"result.body: "+model.data.TermAndConditionEnglish)
//                    }
//
//                }
//            }
//        }


//        synchronized(this){
//            CoroutineScope(Dispatchers.IO).launch {
//                val headers = HashMap<String, String>()
//                headers["Content-Type"] = "application/json; charset=utf-8"
//                headers["lang"] = "en"
//                headers["ElqKey"] = "7e26add827e045e3bd882f19a5a6a382ce47f497b20f48afbaf155301eef3f86f8e681fcfe9040f5a2f643680c0eace5"
//
//
//                val bodyParam = HashMap<String, String>()
//                bodyParam["AmenityId"] = "0"
//                bodyParam["Latitude"] = "37.4219983"
//                bodyParam["Longitude"] = "-122.084"
//                bodyParam["Radius"] = "10000"
//
//
//                val jsonParam=JSONObject()
//                jsonParam.put("email","eve.holt@reqres.in")
//                jsonParam.put("password","pistol")
//
//                // Convert JSONObject to String
//                val jsonObjectString = jsonParam.toString()
//
//                // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
//                val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
//
//
//                val result= retrofit.getRegisterData(requestBody)
//
//                withContext(Dispatchers.Main){
//
//                    Log.d(Constants.tag,"result: "+result)
//
//                    if (result!=null)
//                    {
//                        Log.d(Constants.tag,"result.body: "+result.body())
//
//                    }
//
//                }
//
//            }
//        }

        synchronized(this){
            CoroutineScope(Dispatchers.IO).launch {
                val headers = HashMap<String, String>()
                headers["lang"] = "en"
                headers["ElqKey"] = "7e26add827e045e3bd882f19a5a6a382ce47f497b20f48afbaf155301eef3f86f8e681fcfe9040f5a2f643680c0eace5"
                headers["AppTimeZone"] = ""+Helper.getCurrrentDate("zzzz")


                val jsonParam=JSONObject()
                jsonParam.put("AmenityId","0")
                jsonParam.put("Latitude","37.4219983")
                jsonParam.put("Longitude","-122.084")
                jsonParam.put("Radius","10000")


                // Convert JSONObject to String
                val jsonObjectString = jsonParam.toString()

                // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
                val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


                val result= retrofit.getAmenitiesData(headers,jsonObjectString)

                withContext(Dispatchers.Main){

                    Log.d(Constants.tag,"result: "+result)

                    if (result!=null)
                    {
                        Log.d(Constants.tag,"result.body: "+result.body())

                    }

                }

            }
        }
    }
}