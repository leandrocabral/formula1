package com.leandroid.formula1.info

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.leandroid.data.network.service.InfoService
import com.leandroid.domain.model.Info
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InfoViewModel(
    application: Application,
    private var remoteInfoService: InfoService
) : AndroidViewModel(application) {

    val infoLiveData = MutableLiveData<Info>()

    fun getInfo(type: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val info = withContext(Dispatchers.Default) {
                remoteInfoService.getInfo(type)
            }
            infoLiveData.value = info
        }
    }
}