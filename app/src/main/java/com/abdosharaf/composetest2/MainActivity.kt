package com.abdosharaf.composetest2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember {
            mutableStateOf("")
        }

        var text2 by remember {
            mutableStateOf("")
        }

        var text3 by remember {
            mutableStateOf("")
        }

        Text(text = "Text Field", color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            value = text,
            onValueChange = { newValue -> text = newValue },
            enabled = true,
            readOnly = false,
            label = {
                Text(text = "Email")
            },
//            maxLines = 2,
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
            },
            trailingIcon = {
                if (text.isNotEmpty() || text.isNotBlank()) {
                    IconButton(onClick = { text = "" }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear",
                            tint = Color.Red
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (text.isNotEmpty() || text.isNotBlank()) {
                        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Outlined Text Field", color = Color.Black)

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            value = text2,
            onValueChange = { newValue -> text2 = newValue },
            enabled = true,
            readOnly = false,
            label = {
                Text(text = "Email")
            },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
            },
            trailingIcon = {
                if (text2.isNotEmpty() || text2.isNotBlank()) {
                    IconButton(onClick = { text2 = "" }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear",
                            tint = Color.Red
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (text2.isNotEmpty() || text2.isNotBlank()) {
                        Toast.makeText(context, text2, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Basic Text Field", color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(16.dp),
            value = text3,
            onValueChange = { newValue -> text3 = newValue },
            enabled = true,
            readOnly = false,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (text3.isNotEmpty() || text3.isNotBlank()) {
                        Toast.makeText(context, text3, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        )
    }
}