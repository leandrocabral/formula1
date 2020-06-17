package com.leandroid.data.network.champion

import com.leandroid.domain.model.Champion
import io.reactivex.Single
import retrofit2.http.GET


interface RemoteChampionService {
    @GET("/champion")
    fun load(): Single<List<Champion>>
}