package com.abdosharaf.composetest2.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abdosharaf.composetest2.util.Constants.UNSPLASH_IMAGES_TABLE
import kotlinx.serialization.Serializable

@Entity(tableName = UNSPLASH_IMAGES_TABLE)
@Serializable
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded
    val urls: Urls,
    val likes: Int,
    @Embedded
    val user: User
)
