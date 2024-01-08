package com.abdosharaf.composetest2.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.abdosharaf.composetest2.model.UnsplashImage

@Composable
fun ListComponent(images: LazyPagingItems<UnsplashImage>, paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(
            count = images.itemCount,
            key = images.itemKey { unsplashImage ->
                unsplashImage.id
            }
        ) { index ->
            val unsplashImage = images[index]
            unsplashImage?.let { image -> UnsplashItem(unsplashImage = image) }
        }
    }
}