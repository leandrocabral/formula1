package com.leandroid.data.network.race

import com.leandroid.data.network.service.RaceService
import com.leandroid.domain.model.Race
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.Retrofit

internal class RaceServiceImpl(private var retrofit: Retrofit):RaceService {

    private val remoteRaceService by lazy { retrofit.create(RemoteRaceService::class.java) }

    override fun getRace(): Single<List<Race>> {
        return remoteRaceService.load()
    }
}