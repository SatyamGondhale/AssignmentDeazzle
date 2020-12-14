package com.deazzle.deazzleassignment.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Picture (@ColumnInfo(name = "large")
                    var large: String,
                    @ColumnInfo(name = "medium")
                    var medium: String,
                    @ColumnInfo(name = "thumbnail")
                    var thumbnail: String)
