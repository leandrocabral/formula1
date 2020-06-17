package com.leandroid.data.local.dao

import androidx.room.*
import com.leandroid.domain.model.Race
import com.leandroid.domain.model.TableNames
import io.reactivex.Maybe

@Dao
interface RaceDao {
    @Query("SELECT * FROM ${TableNames.RACE_TABLE}")
    fun getAll(): Maybe<List<Race>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(race: Race): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(race: Race): Int

    @Query("DELETE FROM ${TableNames.RACE_TABLE}")
    fun deleteAll()
}