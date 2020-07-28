package com.leandroid.data.network.service

import com.leandroid.domain.model.Info

interface InfoService {
    suspend fun getInfo(type: String): Info?
}