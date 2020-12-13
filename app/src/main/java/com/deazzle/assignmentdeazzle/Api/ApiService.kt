package com.deazzle.deazzleassignmentkotlin.api

import com.deazzle.assignmentdeazzle.model.Example
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/")
    fun getResultData(@Query("results") results: Int):Call<Example>
}