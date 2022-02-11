package com.example.swifty_companion.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Project(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("slug")
    val slug: String
)
