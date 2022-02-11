package com.example.swifty_companion.data.repository

import com.example.swifty_companion.data.Networking
import com.example.swifty_companion.data.model.User

class SearchRepository {
    suspend fun getUserByLogin(login: String): User {
        return Networking.intraApi.getUserByLogin(login)
    }
}