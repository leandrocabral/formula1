package com.leandroid.data.local.store

import com.leandroid.data.local.dao.ChampionDao
import com.leandroid.data.local.dao.PilotDao
import com.leandroid.domain.model.Champion
import com.leandroid.domain.model.Pilot
import io.reactivex.Completable
import io.reactivex.Maybe


class LocalChampionStore (private val championDao: ChampionDao){
    fun getChampion(): Maybe<List<Champion>> {
        return championDao.getAll()
    }

    fun addChampion(champion: Champion): Completable {
        return Completable.fromAction {
            championDao.insert(champion)
        }
    }

    fun updateChampion(champion: Champion): Completable {
        return Completable.fromAction {
            championDao.update(champion)
        }
    }

    fun clearAll(): Completable {
        return Completable.fromAction {
            championDao.deleteAll()
        }
    }
}