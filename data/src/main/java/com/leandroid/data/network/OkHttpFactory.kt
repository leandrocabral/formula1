package com.leandroid.data.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

internal class OkHttpFactory {
    fun getOkHttpInstance(interceptorFactory: InterceptorFactory): OkHttpClient {
        return OkHttpClient()
            .newBuilder().apply {
                interceptorFactory.getInterceptors().forEach {
                    addInterceptor(it)
                }
            }
            .callTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }
}