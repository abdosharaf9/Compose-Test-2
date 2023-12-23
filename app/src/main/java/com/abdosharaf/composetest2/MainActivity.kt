package com.abdosharaf.composetest2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

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
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val context = LocalContext.current
        GradientButton(
            text = "Click Here",
            textStyle = TextStyle(color = Color.White),
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFFAD5389),
                    Color(0xFF3C1053)
                )
            ),
            onClick = {
                Toast.makeText(context, "Button is clicked!", Toast.LENGTH_SHORT).show()
            }
        )
    }
}