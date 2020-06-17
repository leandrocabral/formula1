package com.leandroid.data.local.repository

import com.leandroid.domain.model.Pilot
import io.reactivex.Completable
import io.reactivex.Maybe

interface PilotRepository {
    fun get(search: String): Maybe<List<Pilot>>
    fun save(pilot: Pilot): Completable
    fun saveList(pilots: List<Pilot>): Completable
    fun update(pilot: Pilot): Completable
    fun clearData(): Completable
}