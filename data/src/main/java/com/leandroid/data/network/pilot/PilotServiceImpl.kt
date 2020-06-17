package com.leandroid.data.network.pilot

import com.leandroid.data.network.service.PilotService
import com.leandroid.domain.model.Pilot
import io.reactivex.Single
import retrofit2.Retrofit

class PilotServiceImpl(private var retrofit: Retrofit) : PilotService {

    private val remotePilotService by lazy { retrofit.create(RemotePilotService::class.java) }

    override fun getPilot(): Single<List<Pilot>> {
        return remotePilotService.load()
    }
}