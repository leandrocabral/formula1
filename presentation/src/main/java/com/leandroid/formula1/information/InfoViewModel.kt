package com.leandroid.formula1.information

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.leandroid.data.network.service.AboutService
import com.leandroid.data.network.service.PrivacyPolicyService
import com.leandroid.data.network.service.TermOfUseService
import com.leandroid.domain.model.About
import com.leandroid.domain.model.PrivacyPolicy
import com.leandroid.domain.model.TermOfUse
import io.reactivex.Single

class InfoViewModel(
    application: Application,
    private var remoteAboutService: AboutService,
    private var remoteTermOfUseService: TermOfUseService,
    private var remotePrivacyPolicyService: PrivacyPolicyService
) : AndroidViewModel(application) {

    fun getAbout(): Single<About> {
        return remoteAboutService.getAbout()
    }

    fun getTermOfUse(): Single<TermOfUse> {
        return remoteTermOfUseService.getTermOfUse()
    }

    fun getPrivacyPolicy(): Single<PrivacyPolicy> {
        return remotePrivacyPolicyService.getPrivacyPolicy()
    }
}