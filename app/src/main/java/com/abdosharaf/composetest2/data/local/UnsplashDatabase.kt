package com.abdosharaf.composetest2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdosharaf.composetest2.data.local.dao.UnsplashImagesDao
import com.abdosharaf.composetest2.data.local.dao.UnsplashRemoteKeysDao
import com.abdosharaf.composetest2.model.UnsplashImage
import com.abdosharaf.composetest2.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase: RoomDatabase() {

    abstract fun unsplashImagesDao(): UnsplashImagesDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}