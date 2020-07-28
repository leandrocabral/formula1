package com.leandroid.data.network.champion

import com.leandroid.domain.model.Champion
import retrofit2.Call
import retrofit2.http.GET

interface RemoteChampionService {
    @GET("/champion")
    fun load(): Call<List<Champion>>
}