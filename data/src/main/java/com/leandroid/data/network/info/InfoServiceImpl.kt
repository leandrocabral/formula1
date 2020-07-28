package com.leandroid.data.network.info

import com.leandroid.data.network.service.InfoService
import com.leandroid.domain.model.Info
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class InfoServiceImpl(private var retrofit: Retrofit) : InfoService {

    private val remoteInfoService by lazy { retrofit.create(RemoteInfoService::class.java) }

    override suspend fun getInfo(type: String): Info? {
        return withContext(Dispatchers.Default) {
            remoteInfoService.load(type).execute().body()
        }
    }
}