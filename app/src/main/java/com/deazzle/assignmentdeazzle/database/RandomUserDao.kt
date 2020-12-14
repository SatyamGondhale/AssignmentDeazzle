package com.deazzle.deazzleassignmentkotlin.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deazzle.assignmentdeazzle.database.RandomUser


@Dao
interface RandomUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:RandomUser)

    @Query("SELECT * FROM randomuser")
    fun getCacheData(): LiveData<List<RandomUser>>

    @Query("SELECT * FROM randomuser")
    fun getCacheDataList(): List<RandomUser>

    @Query("Select COUNT(*) from randomuser")
    fun getCount():Int
}