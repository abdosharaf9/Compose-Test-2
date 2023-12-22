package com.abdosharaf.composetest2

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GoogleButton(
    text: String,
    loadingText: String,
    onButtonClicked: (() -> Unit)? = null,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    shape: Shape = RoundedCornerShape(8.dp),
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    strokeColor: Color = Color.LightGray,
    icon: Painter = painterResource(id = R.drawable.ic_google),
    iconDescription: String = "Google Logo",
    iconSize: Dp = 20.dp,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    indicatorSize: Dp = 16.dp,
    indicatorStrokeWidth: Dp = 2.dp
) {
    var isLoading by remember {
        mutableStateOf(false)
    }

    Surface(
        shape = shape,
        border = BorderStroke(width = 1.dp, color = strokeColor),
        color = backgroundColor,
        onClick = {
            isLoading = !isLoading
            onButtonClicked?.invoke()
        }
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = iconDescription,
                tint = Color.Unspecified,
                modifier = Modifier.size(iconSize)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = if (isLoading) loadingText else text, style = textStyle)

            if (isLoading) {
                Spacer(modifier = Modifier.width(16.dp))

                CircularProgressIndicator(
                    modifier = Modifier.size(indicatorSize),
                    strokeWidth = indicatorStrokeWidth,
                    color = indicatorColor
                )
            }
        }
    }
}

@Preview
@Composable
fun ButtonTest() {
    GoogleButton(
        text = "Sign Up with Google",
        loadingText = "Loading....",
        onButtonClicked = {
            Log.d("```TAG```", "ButtonTest: Button is clicked")
        }
    )
}