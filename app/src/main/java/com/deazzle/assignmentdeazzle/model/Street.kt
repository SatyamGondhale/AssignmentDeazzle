package com.deazzle.assignmentdeazzle.model

import androidx.room.ColumnInfo

data class Street(@ColumnInfo(name = "name")
                  var name: String,
                  @ColumnInfo(name = "number")
                  var number: Int)