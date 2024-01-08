package com.abdosharaf.composetest2.screens.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.abdosharaf.composetest2.R
import com.abdosharaf.composetest2.model.UnsplashImage
import com.abdosharaf.composetest2.model.Urls
import com.abdosharaf.composetest2.model.User
import com.abdosharaf.composetest2.model.UserLinks

@Composable
fun UnsplashItem(unsplashImage: UnsplashImage) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://unsplash.com/@${unsplashImage.user.username}?utm_source=DemoApp&utm_medium=referral")
                )
                startActivity(context, intent, null)
            },
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(unsplashImage.urls.regular)
                .crossfade(durationMillis = 1000)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .build(), contentDescription = "Unsplash Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .alpha(0.5f),
            color = Color.Black
        ) {}

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Photo by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(unsplashImage.user.username)
                    }
                    append(" on Unsplash")
                },
                color = Color.White,
                fontSize = MaterialTheme.typography.labelLarge.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            LikeCounter(
                modifier = Modifier.weight(3f),
                likes = unsplashImage.likes.toString()
            )
        }
    }
}

@Composable
fun LikeCounter(modifier: Modifier, likes: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Likes Count",
            tint = Color.Red
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = likes,
            color = Color.White,
            fontSize = MaterialTheme.typography.labelMedium.fontSize
        )
    }
}

@Preview
@Composable
fun ImagePreview() {
    UnsplashItem(
        unsplashImage = UnsplashImage(
            id = "verterem", urls = Urls(regular = "ac"), likes = 4413, user = User(
                username = "Kendrick Walters",
                userLinks = UserLinks(html = "urbanitas")
            )
        )
    )
}