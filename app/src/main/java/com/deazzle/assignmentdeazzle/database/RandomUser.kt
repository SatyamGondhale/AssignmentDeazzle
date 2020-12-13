package com.deazzle.assignmentdeazzle.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.deazzle.deazzleassignment.model.Name
import com.deazzle.deazzleassignment.model.Picture


@Entity(tableName = "randomuser")
class RandomUser(@PrimaryKey @ColumnInfo(name = "id") val id: Int,
                 @Embedded val name: Name,
                 @Embedded val pic: Picture
)
