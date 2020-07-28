package com.leandroid.data.network.info

import com.leandroid.domain.model.Info
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteInfoService {
    @GET("/info")
    fun load(@Query("type") type: String): Call<Info>
}