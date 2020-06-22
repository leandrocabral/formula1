package com.leandroid.data.network.termOfUse

import com.leandroid.data.network.service.TermOfUseService
import com.leandroid.domain.model.TermOfUse
import io.reactivex.Single
import retrofit2.Retrofit

class TermOfUseServiceImpl(private var retrofit: Retrofit) : TermOfUseService {

    private val remoteTermOfUseService by lazy { retrofit.create(RemoteTermOfUseService::class.java) }

    override fun getTermOfUse(): Single<TermOfUse> {
        return remoteTermOfUseService.load()
    }
}