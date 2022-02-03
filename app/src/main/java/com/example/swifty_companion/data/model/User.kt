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
    val imageUrl: String,

    @SerialName("email")
    val email: String,

    @SerialName("displayname")
    val displayname: String,

    @SerialName("phone")
    val phone: String,

    @SerialName("cursus_users")
    val cursUsers: List<GradeUser>,

    @SerialName("wallet")
    val wallet: Int,

    @SerialName("projects_users")
    val projectUsers: List<ProjectUsers>
)
