package com.leandroid.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.leandroid.domain.model.Pilot
import com.leandroid.domain.model.TableNames
import io.reactivex.Maybe

interface PilotDao {
    @Query("SELECT * FROM ${TableNames.PILOT_TABLE}")
    fun getAll(): Maybe<List<Pilot>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pilot: Pilot): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(cart: List<Pilot>): List<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(pilot: Pilot): Int

    @Query("DELETE FROM ${TableNames.PILOT_TABLE}")
    fun deleteAll()
}