package com.abdosharaf.composetest2

class StudentsRepository {
    private val students = listOf(
        Student(id = 0, firstName = "Abdo", lastName = "Sharaf", age = 21),
        Student(id = 1, firstName = "Ziad", lastName = "Sharaf", age = 18),
        Student(id = 2, firstName = "Mohamed", lastName = "Sharaf", age = 9),
        Student(id = 3, firstName = "Ashraf", lastName = "Sharaf", age = 52),
        Student(id = 4, firstName = "Ziad", lastName = "Wael", age = 21),
        Student(id = 5, firstName = "Ziad", lastName = "ElHelaly", age = 21),
        Student(id = 6, firstName = "Asem", lastName = "Reda", age = 21),
        Student(id = 7, firstName = "Amr", lastName = "Mohamed", age = 21),
        Student(id = 8, firstName = "Mahmoud", lastName = "Ewida", age = 21),
        Student(id = 9, firstName = "Omar", lastName = "Khairy", age = 21),
    )

    fun getStudents() = students
}