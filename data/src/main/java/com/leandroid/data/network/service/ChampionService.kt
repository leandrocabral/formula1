package com.leandroid.data.network.service

import com.leandroid.domain.model.Champion
import io.reactivex.Single

interface ChampionService {
    fun getChampion(): Single<List<Champion>>
}