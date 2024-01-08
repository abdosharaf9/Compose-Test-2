package com.abdosharaf.composetest2.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val username: String,
    @Embedded
    @SerialName("links")
    val userLinks: UserLinks
)
