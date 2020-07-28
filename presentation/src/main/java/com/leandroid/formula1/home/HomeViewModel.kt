package com.leandroid.formula1.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.network.service.PilotService
import com.leandroid.domain.model.Pilot
import com.leandroid.domain.model.Race
import io.reactivex.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    application: Application,
    private var remotePiloService: PilotService
) : AndroidViewModel(application) {

    val pilotLiveData = MutableLiveData<List<Pilot>>()

    fun getRace() {
        CoroutineScope(Dispatchers.Main).launch {
            val pilots = withContext(Dispatchers.Default) {
                remotePiloService.getPilot()
            }
            pilotLiveData.value = pilots
        }
    }

}