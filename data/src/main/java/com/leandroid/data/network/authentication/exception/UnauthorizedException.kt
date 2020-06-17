package com.leandroid.data.network.authentication.interceptor.exception

import com.leandroid.data.network.exception.NetworkException

class UnauthorizedException : NetworkException(401, 0, "Unauthorized")