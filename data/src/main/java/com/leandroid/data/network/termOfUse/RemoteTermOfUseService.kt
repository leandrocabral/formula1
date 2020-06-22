package com.leandroid.data.network.termOfUse

import com.leandroid.domain.model.TermOfUse
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteTermOfUseService {
    @GET("/termOfUse")
    fun load(): Single<TermOfUse>
}