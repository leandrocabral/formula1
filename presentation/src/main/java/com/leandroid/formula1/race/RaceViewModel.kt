package com.leandroid.formula1.race

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.network.service.RaceService
import com.leandroid.domain.model.Champion

import com.leandroid.domain.model.Race
import io.reactivex.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RaceViewModel(application: Application, private var remoteRaceService: RaceService) :
    AndroidViewModel(application) {

    val raceLiveData = MutableLiveData<List<Race>>()

    fun getRace() {
        CoroutineScope(Dispatchers.Main).launch {
            val races = withContext(Dispatchers.Default) {
                remoteRaceService.getRace()
            }
            raceLiveData.value = races
        }
    }
}