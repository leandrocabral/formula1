package com.leandroid.data.network.about

import com.leandroid.data.network.service.AboutService
import com.leandroid.domain.model.About
import io.reactivex.Single
import retrofit2.Retrofit

class AboutServiceImpl(private var retrofit: Retrofit) : AboutService {

    private val remoteAboutService by lazy { retrofit.create(RemoteAboutService::class.java) }

    override fun getAbout(): Single<About> {
        return remoteAboutService.load()
    }
}