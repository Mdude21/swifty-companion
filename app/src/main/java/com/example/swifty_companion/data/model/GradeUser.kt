package com.example.swifty_companion.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradeUser(
    @SerialName("level")
    val level : Double,

    @SerialName("skills")
    val skills: List<Skills>


)
