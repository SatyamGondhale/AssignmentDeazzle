package com.deazzle.deazzleassignmentkotlin.database

import android.app.Application
import android.util.Log
import kotlin.concurrent.schedule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deazzle.assignmentdeazzle.model.Example
import com.deazzle.assignmentdeazzle.model.Result
import com.deazzle.deazzleassignmentkotlin.api.ApiService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(application: Application) {
    var getResponseListMain:MutableLiveData<List<Result>>?=null
    var db=UsersDatabase.getDatabase(application)
    var apiService:ApiService?=null
    var responseList= listOf<Result>()
    constructor(application: Application,apiService: ApiService):this(application){
        this.apiService=apiService
        db=UsersDatabase.getDatabase(application)
        getDataFromRepo()
    }


    fun getDataFromRepo():LiveData<List<Result>>?{
        val apicall:Unit= apiService?.getResultData(10)!!.enqueue(object :Callback<Example>{
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                if(response.isSuccessful){
                    responseList=response.body()!!.results
                    getResponseListMain?.postValue(responseList)
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Log.i("Fail",t.message.toString())
            }
        })
        return getResponseListMain
    }



    fun getData():MutableLiveData<List<Result>>? {
     return getResponseListMain
    }
}


