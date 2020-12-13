package com.deazzle.deazzleassignmentkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.deazzle.assignmentdeazzle.database.RandomUser

@Database(entities = arrayOf(RandomUser::class),version = 1,exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    abstract fun randomUserDao(): RandomUserDao

    companion object {
         var INSTANCE: UsersDatabase? = null
        fun getDatabase(context: Context): UsersDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UsersDatabase::class.java,
                    "users_data"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}