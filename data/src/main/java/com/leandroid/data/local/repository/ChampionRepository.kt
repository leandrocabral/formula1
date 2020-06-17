package com.leandroid.data.local.repository

import com.leandroid.domain.model.Champion
import io.reactivex.Completable
import io.reactivex.Maybe

interface ChampionRepository {
    fun get(search: String): Maybe<List<Champion>>
    fun save(champion: Champion): Completable
    fun update(champion: Champion): Completable
    fun clearData(): Completable
}