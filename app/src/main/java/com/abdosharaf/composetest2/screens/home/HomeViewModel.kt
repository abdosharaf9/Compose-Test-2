package com.abdosharaf.composetest2.screens.home

import androidx.lifecycle.ViewModel
import com.abdosharaf.composetest2.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val getAllImages = repository.getAllImages()
}