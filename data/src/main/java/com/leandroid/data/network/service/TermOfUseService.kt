package com.leandroid.data.network.service

import com.leandroid.domain.model.TermOfUse
import io.reactivex.Single


interface TermOfUseService {
    fun getTermOfUse(): Single<TermOfUse>
}