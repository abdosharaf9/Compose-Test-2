package com.abdosharaf.composetest2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abdosharaf.composetest2.util.Constants.UNSPLASH_REMOTE_KEYS_TABLE

@Entity(tableName = UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
