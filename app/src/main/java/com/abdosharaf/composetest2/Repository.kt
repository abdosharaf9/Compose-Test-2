package com.abdosharaf.composetest2

import javax.inject.Inject

class Repository @Inject constructor(private val dao: PersonsDao) {

    val allPersons = dao.getAllPersons()
}