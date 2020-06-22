package com.leandroid.data.network.service

import com.leandroid.domain.model.PrivacyPolicy
import io.reactivex.Single


interface PrivacyPolicyService {
    fun getPrivacyPolicy(): Single<PrivacyPolicy>
}