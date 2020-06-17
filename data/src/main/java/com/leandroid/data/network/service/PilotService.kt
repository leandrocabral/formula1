package com.leandroid.data.network.service

import com.leandroid.domain.model.Pilot
import io.reactivex.Single

interface PilotService {
    fun getPilot(): Single<List<Pilot>>
}