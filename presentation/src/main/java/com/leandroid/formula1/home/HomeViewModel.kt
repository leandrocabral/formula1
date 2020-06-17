package com.leandroid.formula1.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.leandroid.data.network.service.PilotService
import com.leandroid.domain.model.Pilot
import io.reactivex.Single

class HomeViewModel(
    application: Application,
    private var remotePiloService: PilotService
) : AndroidViewModel(application) {

    fun getPilot(): Single<List<Pilot>> {
        return remotePiloService.getPilot()
    }
}