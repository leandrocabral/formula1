package com.leandroid.data.network.privacyPolicy

import com.leandroid.data.network.service.PrivacyPolicyService
import com.leandroid.domain.model.PrivacyPolicy
import io.reactivex.Single
import retrofit2.Retrofit

class PrivacyPolicyServiceImpl(private var retrofit: Retrofit) : PrivacyPolicyService {

    private val remotePrivacyPolicyService by lazy { retrofit.create(RemotePrivacyPolicyService::class.java) }

    override fun getPrivacyPolicy(): Single<PrivacyPolicy> {
        return remotePrivacyPolicyService.load()
    }
}