package com.leandroid.data.network.race

import com.leandroid.domain.model.Race
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface RemoteRaceService {
    @GET("/race")
    fun load(): Call<List<Race>>
}