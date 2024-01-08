package com.abdosharaf.composetest2.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.abdosharaf.composetest2.data.local.UnsplashDatabase
import com.abdosharaf.composetest2.data.paging.SearchPagingSource
import com.abdosharaf.composetest2.data.paging.UnsplashRemoteMediator
import com.abdosharaf.composetest2.data.remote.UnsplashApi
import com.abdosharaf.composetest2.model.UnsplashImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val database: UnsplashDatabase
) {

    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { database.unsplashImagesDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = UnsplashRemoteMediator(database = database, unsplashApi = unsplashApi),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashApi, query = query)
            }
        ).flow
    }
}