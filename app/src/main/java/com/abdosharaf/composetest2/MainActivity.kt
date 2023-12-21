package com.abdosharaf.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdosharaf.composetest2.ui.theme.ComposeTest2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTest2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTest2Theme {
        /*Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .weight(1f),
                color = MaterialTheme.colorScheme.primary
            ) {}

            Surface(
                modifier = Modifier
                    .width(200.dp)
                    .weight(3f),
                color = MaterialTheme.colorScheme.secondary
            ) {}
        }*/

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            /*Surface(
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f),
                color = MaterialTheme.colorScheme.primary
            ) {}

            Surface(
                modifier = Modifier
                    .height(50.dp)
                    .weight(3f),
                color = MaterialTheme.colorScheme.secondary
            ) {}*/
            SurfaceItem(weight = 3f, MaterialTheme.colorScheme.secondary)
            SurfaceItem(weight = 1f)
        }
    }
}

@Composable
fun RowScope.SurfaceItem(weight: Float, color: Color = MaterialTheme.colorScheme.primary) {
    Surface(
        modifier = Modifier
            .height(50.dp)
            .weight(weight),
        color = color
    ) {}
}

@Composable
fun ColumnScope.SurfaceItem(weight: Float, color: Color = MaterialTheme.colorScheme.primary) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color
    ) {}
}