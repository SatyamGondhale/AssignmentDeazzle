package com.deazzle.assignmentdeazzle.model

import com.deazzle.assignmentdeazzle.database.RandomUser
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data  class Example(
    @SerializedName("results")
    @Expose
    var results:List<Result>?=null
)