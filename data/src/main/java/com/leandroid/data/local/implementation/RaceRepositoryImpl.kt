package com.leandroid.data.local.implementation

import com.leandroid.data.local.store.LocalRaceStore
import com.leandroid.data.local.repository.RaceRepository
import com.leandroid.domain.model.Race
import io.reactivex.Completable
import io.reactivex.Maybe

class RaceRepositoryImpl(private val localRaceStore: LocalRaceStore) : RaceRepository {
    override fun get(search: String): Maybe<List<Race>> {
        return localRaceStore.getRace()
    }

    override fun save(race: Race): Completable {
        return localRaceStore.addRace(race)
    }

    override fun update(race: Race): Completable {
        return localRaceStore.updateRace(race)
    }

    override fun clearData(): Completable {
        return localRaceStore.clearAll()
    }
}