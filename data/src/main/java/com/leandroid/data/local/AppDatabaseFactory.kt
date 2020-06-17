package com.leandroid.data.local

import android.content.Context
import androidx.room.Room
import com.leandroid.data.local.dao.AppDatabase

internal class AppDatabaseFactory {
    fun getInstance(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "local_database")
            .build()
    }
}