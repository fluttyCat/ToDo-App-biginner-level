package dev.fluttycatgeek.todoapplication.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.fluttycatgeek.todoapplication.core.dao.ToDoDao
import dev.fluttycatgeek.todoapplication.core.dto.TodoTaskDto

@Database(
    entities =
    [
        TodoTaskDto::class
    ],
    version = 1, exportSchema = false
)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao
}
