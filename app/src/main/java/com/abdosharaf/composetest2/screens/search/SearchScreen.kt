package com.abdosharaf.composetest2.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.abdosharaf.composetest2.screens.common.ListComponent

@Composable
fun SearchScreen(
    onCloseClicked: () -> Unit,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery
    val searchedImages = searchViewModel.searchedImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchWidget(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    searchViewModel.searchImages(query = it)
                },
                onCloseClicked = {
                    if (searchQuery.isNotEmpty()) {
                        searchViewModel.updateSearchQuery("")
                        searchViewModel.updateSearchedImages()
                    } else {
                        onCloseClicked()
                    }
                }
            )
        }
    ) {
        ListComponent(images = searchedImages, paddingValues = it)
    }
}