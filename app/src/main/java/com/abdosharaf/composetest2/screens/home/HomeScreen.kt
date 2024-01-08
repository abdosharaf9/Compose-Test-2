package com.abdosharaf.composetest2.screens.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.abdosharaf.composetest2.screens.common.ListComponent

@Composable
fun HomeScreen(
    onSearchClicked: () -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = onSearchClicked)
        }
    ) {
        ListComponent(images = getAllImages, paddingValues = it)
    }
}