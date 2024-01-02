package com.abdosharaf.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}

@Composable
fun MainScreen() {
    val icons = listOf(
        Icons.Default.AccountCircle,
        Icons.Default.CheckCircle,
        Icons.Default.AccountBox,
        Icons.Default.DateRange,
        Icons.Default.Email
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, color = Color.Black),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier.weight(1f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        BoxWithConstraints(modifier = Modifier.weight(1.5f)) {
            val iconSize = 24.dp
            val padding = 24.dp
            val numberOfIconsToShow = maxWidth.div(iconSize + padding).toInt().minus(1)
            val remainingIcons = icons.size - numberOfIconsToShow

            Row(horizontalArrangement = Arrangement.spacedBy(padding)) {
                icons.take(numberOfIconsToShow).forEach {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        modifier = Modifier.size(iconSize)
                    )
                }

                if (remainingIcons > 0) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.LightGray)
                            .padding(6.dp)
                    ) {
                        Text(text = "+$remainingIcons")
                    }
                }
            }
        }
    }
}