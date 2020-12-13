package com.deazzle.assignmentdeazzle.viewmodel

import android.app.Application
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deazzle.assignmentdeazzle.model.Example
import com.deazzle.assignmentdeazzle.model.Result
import com.deazzle.deazzleassignmentkotlin.api.Api
import com.deazzle.deazzleassignmentkotlin.api.ApiService
import com.deazzle.deazzleassignmentkotlin.database.Repository


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    var repository:Repository?=null
    var vmData:LiveData<List<Result>>?=null
    var responseList= listOf<Result>()
    var apiService: ApiService?=null
    init {
        apiService= Api.getClient
        repository=Repository(application, apiService!!)
        val handler = Handler()
        handler.postDelayed({
            //responseList=repository!!.getData()
            vmData=repository!!.getData()
        }, 5000)

    }

    fun getDataFromVm(): LiveData<List<Result>>? {
        return vmData
    }

}