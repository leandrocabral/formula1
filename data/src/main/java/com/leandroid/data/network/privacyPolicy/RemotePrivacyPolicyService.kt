package com.leandroid.data.network.privacyPolicy

import com.leandroid.domain.model.PrivacyPolicy
import io.reactivex.Single
import retrofit2.http.GET

interface RemotePrivacyPolicyService {
    @GET("/privacyPolicy")
    fun load(): Single<PrivacyPolicy>
}