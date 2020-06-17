package com.leandroid.data.local.store

import com.leandroid.data.local.dao.PilotDao
import com.leandroid.domain.model.Pilot
import io.reactivex.Completable
import io.reactivex.Maybe

class LocalPilotStore (private val pilotDao: PilotDao){
    fun getPilot(): Maybe<List<Pilot>> {
        return pilotDao.getAll()
    }

    fun addPilot(pilot: Pilot): Completable {
        return Completable.fromAction {
            pilotDao.insert(pilot)
        }
    }

    fun addPilots(pilots: List<Pilot>): Completable {
        return Completable.fromAction {
            pilotDao.insertList(pilots)
        }
    }

    fun updatePilot(pilot: Pilot): Completable {
        return Completable.fromAction {
            pilotDao.update(pilot)
        }
    }

    fun clearAll(): Completable {
        return Completable.fromAction {
            pilotDao.deleteAll()
        }
    }
}