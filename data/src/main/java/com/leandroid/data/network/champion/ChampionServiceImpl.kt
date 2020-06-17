package com.leandroid.data.network.champion

import com.leandroid.data.network.service.ChampionService
import com.leandroid.domain.model.Champion
import io.reactivex.Single
import retrofit2.Retrofit

class ChampionServiceImpl(private var retrofit: Retrofit) : ChampionService {

    private val remoteChampionService by lazy { retrofit.create(RemoteChampionService::class.java) }

    override fun getChampion(): Single<List<Champion>> {
        return remoteChampionService.load()
    }
}