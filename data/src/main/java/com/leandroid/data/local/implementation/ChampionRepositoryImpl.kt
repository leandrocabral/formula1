package com.leandroid.data.local.implementation

import com.leandroid.data.local.repository.ChampionRepository
import com.leandroid.data.local.store.LocalChampionStore
import com.leandroid.domain.model.Champion
import io.reactivex.Completable
import io.reactivex.Maybe

class ChampionRepositoryImpl(private val localChampionStore: LocalChampionStore) :
    ChampionRepository {
    override fun get(search: String): Maybe<List<Champion>> {
        return localChampionStore.getChampion()
    }

    override fun save(champion: Champion): Completable {
        return localChampionStore.addChampion(champion)
    }

    override fun update(champion: Champion): Completable {
        return localChampionStore.updateChampion(champion)
    }

    override fun clearData(): Completable {
        return localChampionStore.clearAll()
    }
}