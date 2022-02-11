package com.example.swifty_companion.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skills(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("level")
    val level: Double
)
