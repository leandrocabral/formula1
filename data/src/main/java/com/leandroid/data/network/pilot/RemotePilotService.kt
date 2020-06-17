package com.leandroid.data.network.pilot

import com.leandroid.domain.model.Pilot
import io.reactivex.Single
import retrofit2.http.GET

interface RemotePilotService {
    @GET("/pilot")
    fun load(): Single<List<Pilot>>
}