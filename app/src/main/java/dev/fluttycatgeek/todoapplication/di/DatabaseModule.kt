package dev.fluttycatgeek.todoapplication.di

import android.app.Application
import androidx.room.Room
import dagger.Provides
import dev.fluttycatgeek.todoapplication.core.dao.ToDoDao
import dev.fluttycatgeek.todoapplication.core.db.ToDoDatabase
import dev.fluttycatgeek.todoapplication.core.utils.Constants.DATABASE_NAME
import javax.inject.Singleton

object DatabaseModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): ToDoDatabase {
        return Room
            .databaseBuilder(app, ToDoDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserInfoDao(db: ToDoDatabase): ToDoDao {
        return db.todoDao()
    }
}