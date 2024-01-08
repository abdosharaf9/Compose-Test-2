package com.abdosharaf.composetest2.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdosharaf.composetest2.model.UnsplashImage
import com.abdosharaf.composetest2.util.Constants.UNSPLASH_IMAGES_TABLE

@Dao
interface UnsplashImagesDao {

    @Query("SELECT * FROM $UNSPLASH_IMAGES_TABLE")
    fun getAllImages(): PagingSource<Int, UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnsplashImage>)

    @Query("DELETE FROM $UNSPLASH_IMAGES_TABLE")
    suspend fun deleteAllImages()
}