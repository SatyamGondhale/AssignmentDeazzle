package com.deazzle.deazzleassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Name {
    @SerializedName("title")
    @Expose
    public var title: String? = null

    @SerializedName("first")
    @Expose
    public var first: String? = null

    @SerializedName("last")
    @Expose
    public var last: String? = null

}