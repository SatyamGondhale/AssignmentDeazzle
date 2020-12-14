package com.deazzle.deazzleassignment.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Name ( @ColumnInfo(name = "title")
                  var title: String,
                  @ColumnInfo(name = "first")
                  var first: String,
                  @ColumnInfo(name = "last")
                  var last: String)