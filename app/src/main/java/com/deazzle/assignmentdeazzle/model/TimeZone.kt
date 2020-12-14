package com.deazzle.assignmentdeazzle.model

import androidx.room.ColumnInfo

data class TimeZone(@ColumnInfo(name = "offset")
                    var offset: String,
                    @ColumnInfo(name = "description")
                    var description: String)