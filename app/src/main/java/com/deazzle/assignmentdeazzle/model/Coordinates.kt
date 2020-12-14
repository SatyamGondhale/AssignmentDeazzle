package com.deazzle.assignmentdeazzle.model

import androidx.room.ColumnInfo

data class Coordinates(@ColumnInfo(name = "latitude")
                       var latitude: String,
                       @ColumnInfo(name = "longitude")
                       var longitude: String)