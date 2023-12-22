package com.abdosharaf.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.util.TypedValueCompat.dpToPx
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation

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
        /*val painter = rememberImagePainter(data = "https://picsum.photos/600/600", builder = {
//            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_background)
            crossfade(1000)
            transformations(
//                GrayscaleTransformation()
//                CircleCropTransformation()
//                BlurTransformation()
                RoundedCornersTransformation(50f)
            )
        })
        val painterState = painter.state

        Image(painter = painter, contentDescription = "Image", modifier = Modifier.size(200.dp))

        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }*/

//        AsyncImage(model = "https://picsum.photos/600/600", contentDescription = "Image")

        /*AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://picsum.photos/600/600")
                .crossfade(true)
                .placeholder(R.drawable.ic_launcher_background)
                .transformations(
                    RoundedCornersTransformation(50f)
                )
                .size(400)
                .build(),
            contentDescription = "Image"
        )*/

        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://picsum.photos/600/600")
                .crossfade(true)
                .placeholder(R.drawable.ic_launcher_background)
                .transformations(
                    RoundedCornersTransformation(50f)
                )
                .size(400)
                .build()
        )
        Image(painter = painter, contentDescription = "Image")
    }
}