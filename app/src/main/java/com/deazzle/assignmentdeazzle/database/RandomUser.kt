package com.deazzle.assignmentdeazzle.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.deazzle.assignmentdeazzle.model.Location
import com.deazzle.assignmentdeazzle.model.Login
import com.deazzle.deazzleassignment.model.Name
import com.deazzle.deazzleassignment.model.Picture
import com.google.gson.annotations.SerializedName


@Entity(tableName = "randomuser")
data class RandomUser(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
                      @ColumnInfo(name = "email")
                      val email:String,
                      @ColumnInfo(name = "phone")
                      val phone:String,
                      @SerializedName("name")
                      @Embedded val name: Name,
                      @SerializedName("picture")
                      @Embedded val pic: Picture,
                      @SerializedName("login")
                      @Embedded val login:Login,
                      @SerializedName("location")
                      @Embedded val location:Location)
