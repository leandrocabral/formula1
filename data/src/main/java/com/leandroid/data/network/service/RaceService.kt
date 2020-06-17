package com.leandroid.data.network.service

import com.leandroid.domain.model.Race
import io.reactivex.Single

interface RaceService {
    fun getRace(): Single<List<Race>>
}