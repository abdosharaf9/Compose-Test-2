package com.abdosharaf.composetest2

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonsDao {
    @Query("SELECT * FROM persons_table")
    fun getAllPersons(): Flow<List<Person>>
}