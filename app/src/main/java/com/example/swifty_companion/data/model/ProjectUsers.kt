package com.example.swifty_companion.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectUsers(
    @SerialName("id")
    val id: Long,

    @SerialName("final_mark")
    val finalMark: Long?,

    @SerialName("status")
    val status: String,

    @SerialName("project")
    val project: Project,

    @SerialName("validated?")
    val validation: Boolean?,

    )
