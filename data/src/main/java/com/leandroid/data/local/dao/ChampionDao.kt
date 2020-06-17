package com.leandroid.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.leandroid.domain.model.Champion
import com.leandroid.domain.model.Pilot
import com.leandroid.domain.model.TableNames
import io.reactivex.Maybe

interface ChampionDao {
    @Query("SELECT * FROM ${TableNames.CHAMPION_TABLE}")
    fun getAll(): Maybe<List<Champion>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(champion: Champion): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(champion: Champion): Int

    @Query("DELETE FROM ${TableNames.CHAMPION_TABLE}")
    fun deleteAll()
}