package com.leandroid.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leandroid.domain.model.Race

@Database(entities = [Race::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun raceDao(): RaceDao
    abstract fun pilotDao(): PilotDao
    abstract fun championDao(): ChampionDao
}