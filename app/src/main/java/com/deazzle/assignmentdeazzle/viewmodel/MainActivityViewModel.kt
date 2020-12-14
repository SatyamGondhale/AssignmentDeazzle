package com.deazzle.assignmentdeazzle.viewmodel

import android.app.Application
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deazzle.assignmentdeazzle.database.RandomUser
import com.deazzle.deazzleassignmentkotlin.api.Api
import com.deazzle.deazzleassignmentkotlin.api.ApiService
import com.deazzle.deazzleassignmentkotlin.database.Repository
import com.deazzle.deazzleassignmentkotlin.database.UsersDatabase


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    var repository:Repository?=null
    var vmData:LiveData<List<RandomUser>>?=null
    var vmDataMutable:MutableLiveData<List<RandomUser>>?=null
    var db= UsersDatabase.getDatabase(application)
    var apiService: ApiService?=null
    init {
        apiService= Api.getClient
        repository=Repository(application, apiService!!)
        db= UsersDatabase.getDatabase(application)
        val isDataAvailale:Int=db.randomUserDao().getCount()
        if(isDataAvailale>0){
           vmData=db.randomUserDao().getCacheData()
        }else{
            val handler = Handler()
            handler.postDelayed({
                vmDataMutable=repository?.getDataFromRepo()
                vmData=vmDataMutable
              //  vmData=vmDataMutable
            }, 10000)
        }

    }

    fun getDataFromVm(): LiveData<List<RandomUser>>? {
        return vmData
    }

}