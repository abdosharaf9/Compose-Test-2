package com.abdosharaf.composetest2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int
)