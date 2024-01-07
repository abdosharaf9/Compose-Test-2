package com.abdosharaf.composetest2.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdosharaf.composetest2.SMSMessage
import com.abdosharaf.composetest2.parsedDate

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MessagePreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        repeat(10) {
            SmsMessageComponent(
                message = SMSMessage(
                    message = "nonumy",
                    sender = "utamur",
                    date = 7606,
                    read = false,
                    type = if (it % 2 == 0) 1 else 2,
                    thread = 5117,
                    service = "nobis"
                )
            )
        }
    }
}

@Composable
fun SmsMessageComponent(message: SMSMessage) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.type == 1) Arrangement.Start else Arrangement.End
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(10.dp),
            shape = RoundedCornerShape(12.dp),
            color = if (message.type == 1) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.tertiaryContainer
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(text = message.message, color = MaterialTheme.colorScheme.onSurface)

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = message.date.parsedDate().split(" ").last(),
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.38f)
                )
            }
        }
    }
}