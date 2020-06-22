package com.leandroid.data.network.service

import com.leandroid.domain.model.About
import io.reactivex.Single

interface AboutService {
    fun getAbout(): Single<About>
}