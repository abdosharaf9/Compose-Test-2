package com.abdosharaf.composetest2

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SimpleTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun noClick_Assert_HiDoesNotExist() {
        composeTestRule.setContent {
            MainScreen()
        }
        composeTestRule.onNodeWithTag("Hi").assertDoesNotExist()
    }
}