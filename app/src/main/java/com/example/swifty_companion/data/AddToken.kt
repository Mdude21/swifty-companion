package com.example.swifty_companion.data

import com.example.swifty_companion.data.repository.AuthRepository
import okhttp3.Interceptor
import okhttp3.Response

class AddToken : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val token = AuthConfig.TOKEN
        val originalRequest = chain.request()

        val request = if (token != null) {
            originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        } else {
            originalRequest
        }

        return chain.proceed(request)
    }
}