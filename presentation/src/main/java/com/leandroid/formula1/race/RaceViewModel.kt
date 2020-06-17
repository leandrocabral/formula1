package com.leandroid.formula1.race

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.leandroid.data.network.service.RaceService

import com.leandroid.domain.model.Race
import io.reactivex.Single

class RaceViewModel(application: Application, private var remoteRaceService: RaceService) :
    AndroidViewModel(application) {

    fun getRace(): Single<List<Race>> {
        return remoteRaceService.getRace()
    }
}