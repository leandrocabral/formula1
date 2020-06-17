package com.leandroid.formula1.champion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.leandroid.data.network.service.ChampionService
import com.leandroid.data.network.service.RaceService
import com.leandroid.domain.model.Champion
import com.leandroid.domain.model.Race
import io.reactivex.Single

class ChampionViewModel(application: Application, private var remoteChampionService: ChampionService) :
    AndroidViewModel(application) {

    fun getChampion(): Single<List<Champion>> {
        return remoteChampionService.getChampion()
    }
}