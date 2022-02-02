package com.example.swifty_companion.data

import com.example.swifty_companion.data.model.ServerItemsWrapper
import com.example.swifty_companion.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IntraApi {
    @GET("v2/users/{login}")
    suspend fun getUserByLogin(
        @Path("login") login: String
    ) : User
}