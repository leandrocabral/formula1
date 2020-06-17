package com.leandroid.data.local.repository

import com.leandroid.domain.model.Race
import io.reactivex.Completable
import io.reactivex.Maybe

interface RaceRepository {
    fun get(search: String): Maybe<List<Race>>
    fun save(race: Race): Completable
    fun update(race: Race): Completable
    fun clearData(): Completable
}