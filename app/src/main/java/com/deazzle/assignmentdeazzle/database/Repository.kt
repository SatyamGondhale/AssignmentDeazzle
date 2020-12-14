package com.deazzle.deazzleassignmentkotlin.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deazzle.assignmentdeazzle.database.RandomUser
import com.deazzle.assignmentdeazzle.model.Example
import com.deazzle.assignmentdeazzle.model.Result
import com.deazzle.deazzleassignmentkotlin.api.ApiService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(application: Application) {
    var getResponseListMain:LiveData<List<RandomUser>>?=null
    var getResponseListMainMutable:MutableLiveData<List<RandomUser>>?=null
    var db=UsersDatabase.getDatabase(application)
    var apiService:ApiService?=null
    var responseList= ArrayList<RandomUser>()
    constructor(application: Application,apiService: ApiService):this(application){
        this.apiService=apiService
        db=UsersDatabase.getDatabase(application)
        val isDataAvailale:Int=db.randomUserDao().getCount()
        if(isDataAvailale>0){
            getResponseListMain=db.randomUserDao().getCacheData()
        }else{
            getDataFromRepo()
        }
    }


    fun getDataFromRepo():MutableLiveData<List<RandomUser>>?{
        val apicall:Unit= apiService?.getResultData(10)!!.enqueue(object :Callback<Example>{
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                if(response.isSuccessful){
                    var tempResponse=listOf<Result>()
                           tempResponse= response.body()?.results!!
                    for(result in tempResponse.indices){
                       val user=RandomUser(id = 0,name = tempResponse.get(result).name,pic = tempResponse.get(result).picture,email = tempResponse.get(result).email,
                           phone = tempResponse.get(result).phone,login = tempResponse.get(result).login,location =tempResponse.get(result).location
                       )
                        responseList.toMutableList().add(user)
                        db.randomUserDao().insertUser(user)
                    }
                    getResponseListMainMutable?.value=responseList
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Log.i("Fail",t.message.toString())
            }
        })
        return getResponseListMainMutable
    }

    fun getLiveData():MutableLiveData<List<RandomUser>> {
        return getResponseListMainMutable!!
    }
}


