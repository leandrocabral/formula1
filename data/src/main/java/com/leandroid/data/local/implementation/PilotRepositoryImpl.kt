package com.leandroid.data.local.implementation

import com.leandroid.data.local.repository.PilotRepository
import com.leandroid.data.local.store.LocalPilotStore
import com.leandroid.domain.model.Pilot
import io.reactivex.Completable
import io.reactivex.Maybe

class PilotRepositoryImpl(private val localPilotStore: LocalPilotStore) : PilotRepository {
    override fun get(search: String): Maybe<List<Pilot>> {
        return localPilotStore.getPilot()
    }

    override fun save(pilot: Pilot): Completable {
        return localPilotStore.addPilot(pilot)
    }

    override fun saveList(pilots: List<Pilot>): Completable {
        return localPilotStore.addPilots(pilots)
    }

    override fun update(pilot: Pilot): Completable {
        return localPilotStore.updatePilot(pilot)
    }

    override fun clearData(): Completable {
        return localPilotStore.clearAll()
    }
}