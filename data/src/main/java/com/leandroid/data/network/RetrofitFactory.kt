package com.leandroid.data.network

import android.content.Context
import com.leandroid.data.BuildConfig
import com.leandroid.data.R
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


internal class RetrofitFactory {
    fun getRetrofitInstance(
        context: Context,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        var url = if (BuildConfig.DEBUG) { // TODO Use flavor dimensions to set URL
            context.getString(R.string.URL_STAGING)
        } else {
            context.getString(R.string.URL_PRODUCTION)
        }

        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }
}