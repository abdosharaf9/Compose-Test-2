package com.abdosharaf.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
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
    val window = rememberWindowSize()
    when (window.width) {
        WindowType.Compact -> {
            CompactLayout()
        }

        WindowType.Medium -> {
            MediumLayout()
        }

        else -> {
            MediumLayout()
//            ExpandedLayout()
        }
    }
}

@Composable
fun CompactLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut pharetra sodales dolor ut consequat. Morbi tristique laoreet pulvinar. Aliquam erat volutpat. Sed sem odio, tristique ut porta quis, suscipit quis erat. Nunc non velit eu mi fermentum viverra non a leo. Integer maximus leo euismod aliquam sagittis. Nulla eu est diam. Nulla vel velit sed leo suscipit laoreet. Proin nec aliquam orci. Quisque cursus metus et mollis ultrices. Mauris quis lobortis augue. Nunc vitae libero vitae libero elementum lobortis. Ut id consequat neque, ut commodo turpis. Proin magna metus, fringilla quis volutpat ut, tincidunt quis turpis. Nam id maximus erat, vitae lobortis risus. Mauris faucibus convallis iaculis.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            maxLines = 5,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun MediumLayout() {
    Row(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut pharetra sodales dolor ut consequat. Morbi tristique laoreet pulvinar. Aliquam erat volutpat. Sed sem odio, tristique ut porta quis, suscipit quis erat. Nunc non velit eu mi fermentum viverra non a leo. Integer maximus leo euismod aliquam sagittis. Nulla eu est diam. Nulla vel velit sed leo suscipit laoreet. Proin nec aliquam orci. Quisque cursus metus et mollis ultrices. Mauris quis lobortis augue. Nunc vitae libero vitae libero elementum lobortis. Ut id consequat neque, ut commodo turpis. Proin magna metus, fringilla quis volutpat ut, tincidunt quis turpis. Nam id maximus erat, vitae lobortis risus. Mauris faucibus convallis iaculis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut pharetra sodales dolor ut consequat. Morbi tristique laoreet pulvinar. Aliquam erat volutpat. Sed sem odio, tristique ut porta quis, suscipit quis erat. Nunc non velit eu mi fermentum viverra non a leo. Integer maximus leo euismod aliquam sagittis. Nulla eu est diam. Nulla vel velit sed leo suscipit laoreet. Proin nec aliquam orci. Quisque cursus metus et mollis ultrices. Mauris quis lobortis augue. Nunc vitae libero vitae libero elementum lobortis. Ut id consequat neque, ut commodo turpis. Proin magna metus, fringilla quis volutpat ut, tincidunt quis turpis. Nam id maximus erat, vitae lobortis risus. Mauris faucibus convallis iaculis.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            maxLines = 10,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun ExpandedLayout() {
    // The UI design you need
}