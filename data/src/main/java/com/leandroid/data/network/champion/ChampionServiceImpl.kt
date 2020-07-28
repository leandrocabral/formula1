package com.leandroid.data.network.champion

import com.leandroid.data.network.service.ChampionService
import com.leandroid.domain.model.Champion
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Retrofit

class ChampionServiceImpl(private var retrofit: Retrofit) : ChampionService {

    private val remoteChampionService by lazy { retrofit.create(RemoteChampionService::class.java) }

    override suspend fun getChampion(): List<Champion>? {
        return withContext(Dispatchers.Default) {
            remoteChampionService.load().execute().body()
        }
    }
}