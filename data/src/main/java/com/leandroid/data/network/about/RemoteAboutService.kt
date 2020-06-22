package com.leandroid.data.network.about

import com.leandroid.domain.model.About
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteAboutService {
    @GET("/about")
    fun load(): Single<About>
}