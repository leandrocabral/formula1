package com.leandroid.data.network.race

import com.leandroid.data.network.service.RaceService
import com.leandroid.domain.model.Race
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

internal class RaceServiceImpl(private var retrofit: Retrofit):RaceService {

    private val remoteRaceService by lazy { retrofit.create(RemoteRaceService::class.java) }

    override suspend fun getRace(): List<Race>?{
        return withContext(Dispatchers.Default) {
            remoteRaceService.load().execute().body()
        }
    }
}