package com.leandroid.formula1.champion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.network.service.ChampionService
import com.leandroid.data.network.service.RaceService
import com.leandroid.domain.model.Champion
import com.leandroid.domain.model.Race
import io.reactivex.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChampionViewModel(
    application: Application,
    private var remoteChampionService: ChampionService
) : AndroidViewModel(application) {

    val championsLiveData = MutableLiveData<List<Champion>>()

    fun getChampion() {
        CoroutineScope(Dispatchers.Main).launch {
            val champions = withContext(Dispatchers.Default) {
                remoteChampionService.getChampion()
            }
            championsLiveData.value = champions
        }
    }
}