package com.example.swifty_companion.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id")
    val id: Long,

    @SerialName("login")
    val login: String,

    @SerialName("image_url")
    val imageUrl: String
)
