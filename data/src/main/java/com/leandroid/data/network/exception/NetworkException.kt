package com.leandroid.data.network.exception

open class NetworkException(httpStatusCode: Int, errorCode: Int = 0, message: String = "") : Throwable(message)