package com.leandroid.data.network.pilot

import com.leandroid.data.network.service.PilotService
import com.leandroid.domain.model.Pilot
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class PilotServiceImpl(private var retrofit: Retrofit) : PilotService {

    private val remotePilotService by lazy { retrofit.create(RemotePilotService::class.java) }

    override suspend fun getPilot(): List<Pilot>? {
        return withContext(Dispatchers.Default) {
            remotePilotService.load().execute().body()
        }
    }
}