package com.example.swifty_companion.data

import com.example.swifty_companion.data.model.User
import retrofit2.http.GET

interface IntraApi {
    @GET("v2/users/{login}")
    suspend fun getUserByLogin(login: String) : User

}