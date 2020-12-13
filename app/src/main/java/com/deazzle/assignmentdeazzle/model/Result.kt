package com.deazzle.assignmentdeazzle.model

import com.deazzle.deazzleassignment.model.Name
import com.deazzle.deazzleassignment.model.Picture
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("name")
    @Expose
    val name: Name,
    @SerializedName("picture")
    @Expose
    var picture: Picture
)