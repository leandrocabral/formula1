package com.leandroid.formula1.race


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandroid.data.network.service.RaceService


import com.leandroid.domain.model.Race
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RaceViewModel(private var remoteRaceService: RaceService) :  ViewModel() {

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