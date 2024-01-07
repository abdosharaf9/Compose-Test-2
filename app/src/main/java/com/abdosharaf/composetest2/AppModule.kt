package com.abdosharaf.composetest2

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            PersonsDatabase::class.java,
            "app_database"
        ).createFromAsset("database/persons.db").build()

    @Singleton
    @Provides
    fun providePersonsDao(database: PersonsDatabase) = database.personsDao()
}