package com.leandroid.data.local.store

import com.leandroid.data.local.dao.RaceDao
import com.leandroid.domain.model.Race
import io.reactivex.Completable
import io.reactivex.Maybe

class LocalRaceStore(private val raceDao: RaceDao) {

    fun getRace(): Maybe<List<Race>> {
        return raceDao.getAll()
    }

    fun addRace(race: Race): Completable {
        return Completable.fromAction {
            raceDao.insert(race)
        }
    }

    fun updateRace(race: Race): Completable {
        return Completable.fromAction {
            raceDao.update(race)
        }
    }

    fun clearAll(): Completable {
        return Completable.fromAction {
            raceDao.deleteAll()
        }
    }
}