package com.leandroid.data.network.service

import com.leandroid.domain.model.Champion
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call

interface ChampionService {
    suspend fun getChampion(): List<Champion>?
}