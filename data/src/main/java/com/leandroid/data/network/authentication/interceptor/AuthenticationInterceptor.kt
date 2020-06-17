package com.leandroid.data.network.authentication.interceptor

import com.leandroid.data.network.authentication.interceptor.exception.AlreadyHandledNetworkErrorException
import com.leandroid.data.network.authentication.interceptor.exception.UnauthorizedException
import com.leandroid.data.network.exception.NetworkException
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import okhttp3.Interceptor
import okhttp3.Response


class AuthenticationInterceptor(
) : Interceptor {
    private val networkErrorsSubject = PublishSubject.create<NetworkException>()
    val networkErrors: Observable<NetworkException> = networkErrorsSubject

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val request = chain.request()

            val modifiedRequest = request.newBuilder().apply {

            }.build()

            val response = chain.proceed(modifiedRequest)

            when (response.code) {
                401 -> {
                    networkErrorsSubject.onNext(UnauthorizedException())
                    throw AlreadyHandledNetworkErrorException(response.toString())
                }
            }

            return response

        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}