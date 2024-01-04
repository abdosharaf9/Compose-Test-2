package com.abdosharaf.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@FontPreviews
@Composable
fun DefaultPreview() {
    MainScreen()
}

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val state = rememberLazyListState()
        MainContent(state)
        TopBar(state)
    }
}

@Composable
private fun MainContent(state: LazyListState) {
    val list = remember {
        List(size = 25) { it }
    }
    val padding by animateDpAsState(
        targetValue = if (state.isScrolled) 0.dp else 64.dp,
        animationSpec = tween(durationMillis = 300),
        label = ""
    )

    LazyColumn(
        modifier = Modifier.padding(top = padding),
        contentPadding = PaddingValues(16.dp),
        state = state,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(items = list, key = { it }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.LightGray)
            )
        }
    }
}

@Composable
fun TopBar(state: LazyListState) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .animateContentSize(animationSpec = tween(durationMillis = 300))
            .height(if (state.isScrolled) 0.dp else 64.dp),
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        Text(
            text = "Title",
            fontSize = 18.sp,
            color = MaterialTheme.colors.surface
        )
    }
}

val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0