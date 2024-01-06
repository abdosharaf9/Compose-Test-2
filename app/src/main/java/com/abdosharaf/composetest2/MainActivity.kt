package com.abdosharaf.composetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdosharaf.composetest2.ui.theme.ComposeTest2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTest2Theme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}

data class Person(
    val name: String,
    val age: Int
)

@Composable
fun MainScreen() {
    var person by rememberSaveable(stateSaver = PersonSaver) {
        mutableStateOf(Person(name = "Test", age = 30))
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hi, my name is ${person.name}, I'm ${person.age} years old.")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { person = Person(name = "Abdo Sharaf", age = 21) }) {
            Text(text = "Update")
        }
    }
}

object PersonSaver: Saver<Person, Map<String, Any>> {
    override fun restore(value: Map<String, Any>): Person? {
        val name = value["name"] as String
        val age = value["age"] as Int
        return Person(name = name, age = age)
    }

    override fun SaverScope.save(value: Person): Map<String, Any>? {
        return mapOf(
            "name" to value.name,
            "age" to value.age
        )
    }
}