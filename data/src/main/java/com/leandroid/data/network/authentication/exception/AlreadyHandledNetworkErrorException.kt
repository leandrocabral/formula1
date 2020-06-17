package com.leandroid.data.network.authentication.interceptor.exception

import com.leandroid.data.network.exception.NetworkException

class AlreadyHandledNetworkErrorException(override var message: String ="") : NetworkException(0)