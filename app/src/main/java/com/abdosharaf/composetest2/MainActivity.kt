package com.abdosharaf.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .basicMarquee(
                    iterations = Int.MAX_VALUE,
                    animationMode = MarqueeAnimationMode.Immediately,
                    velocity = 100.dp,
                    initialDelayMillis = 0,
                    delayMillis = 0
                ),
            text = "Nick Denton got drudged 5 praise erasers & how to avoid them 5% corruption trolls NPR future of context curmudgeon NYT R&D attracting young readers, Gutenberg parenthesis Sulzberger Quora newsroom cafe Walter Cronkite died for your sins mthomps What Would Google Do This Week in Review, Quora reporting crowdsourcing Politics & Socks page Jeff Jarvis bloggers in their mother's basement morgue future of narrative. vast wasteland the other longer Book Review Dan Fleckner Andy Carvin Fuego people formerly known as the audience explainer The Printing Press as an Agent of Change hyperhyperlocal social media optimization the medium is the massage, MinnPost AP Josh Marshall DocumentCloud abundance Jurgen Habermas Lucius Nieman tools crowdsourcing recontextualize, net neutrality AP the power of the press belongs to the person who owns one fourth estate Reuters experiment Gardening & War section MinnPost explainer.",
            color = Color.White,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            maxLines = 1,
            overflow = TextOverflow.Visible
        )

        Spacer(modifier = Modifier.height(24.dp))

        val focusRequester = remember {
            FocusRequester()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .basicMarquee(
                    iterations = Int.MAX_VALUE,
                    animationMode = MarqueeAnimationMode.WhileFocused,
                    velocity = 150.dp,
                    delayMillis = 0
                )
                .focusRequester(focusRequester)
                .focusable()
        ) {
            Text(
                text = "\uD83D\uDE82",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )

            repeat(20) {
                Text(
                    text = "🚃",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { focusRequester.requestFocus() }) {
            Text(text = "Woo-hoo!")
        }
    }
}