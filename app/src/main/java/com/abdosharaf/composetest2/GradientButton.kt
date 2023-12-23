package com.abdosharaf.composetest2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(
    text: String,
    textStyle: TextStyle,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, style = textStyle)
        }
    }
}

@Preview
@Composable
fun GradientButtonTest() {
    GradientButton(
        text = "Click Here",
        textStyle = TextStyle(color = Color.White),
        gradient = Brush.horizontalGradient(
            colors = listOf(
                Color(0xFFAD5389),
                Color(0xFF3C1053)
            )
        ),
        onClick = {}
    )
}