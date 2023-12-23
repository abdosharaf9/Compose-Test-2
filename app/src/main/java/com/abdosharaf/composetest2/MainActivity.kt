package com.abdosharaf.composetest2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val repository = StudentsRepository()
            val students = repository.getStudents()
            MainScreen(students)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen(emptyList())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(students: List<Student>) {
    val sections = listOf(
        "Section A",
        "Section B",
        "Section C",
        "Section D",
        "Section E",
        "Section F",
        "Section G"
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            /*itemsIndexed(
                items = students,
                key = {index, student -> student.id }
            ) { index, student ->
                Log.d("TAG", "Index = $index")
                CustomItem(student = student)
            }

            item {
                CustomItem(
                    student = Student(
                        id = 0,
                        firstName = "Abdo",
                        lastName = "Sharaf",
                        age = 21
                    )
                )
            }*/
            sections.forEach { section ->
                stickyHeader {
                    Text(
                        text = section,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(12.dp)
                    )
                }

                items(10) {
                    Text(
                        text = "Item ${it+1} in $section",
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}