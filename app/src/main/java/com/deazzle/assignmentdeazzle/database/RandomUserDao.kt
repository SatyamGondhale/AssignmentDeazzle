package com.deazzle.deazzleassignmentkotlin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.deazzle.assignmentdeazzle.database.RandomUser


@Dao
interface RandomUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:RandomUser)

}