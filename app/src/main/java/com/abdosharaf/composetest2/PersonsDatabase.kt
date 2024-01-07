package com.abdosharaf.composetest2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1, exportSchema = true)
abstract class PersonsDatabase: RoomDatabase() {
    abstract fun personsDao(): PersonsDao
}