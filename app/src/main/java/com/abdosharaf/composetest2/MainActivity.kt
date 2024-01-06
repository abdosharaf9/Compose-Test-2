package com.abdosharaf.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
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
    Column(modifier = Modifier.fillMaxSize()) {
        var isVisible by remember {
            mutableStateOf(false)
        }

        Text(modifier = Modifier.testTag("Hello"), text = "Hello!")

        Spacer(modifier = Modifier.height(16.dp))

        Button(modifier = Modifier.testTag("Button"), onClick = { isVisible = !isVisible }) {
            Text(text = if (isVisible) "Hide" else "Show")
        }

        if (isVisible) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(modifier = Modifier.testTag("Hi"), text = "Hi!")
        }
    }
}