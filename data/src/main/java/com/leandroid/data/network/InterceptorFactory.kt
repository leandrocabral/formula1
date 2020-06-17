package com.leandroid.data.network

import com.leandroid.data.BuildConfig
import com.leandroid.data.network.authentication.interceptor.AuthenticationInterceptor
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

internal class InterceptorFactory(
    private val authenticationInterceptor: AuthenticationInterceptor
) {
    fun getInterceptors(): List<Interceptor> {
        return arrayListOf(
            authenticationInterceptor,
            getOkHttpLoggingInterceptorInstance()
        )
    }

    private fun getOkHttpLoggingInterceptorInstance(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }
    }
}