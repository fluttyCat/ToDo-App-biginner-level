package dev.fluttycatgeek.todoapplication.core.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.fluttycatgeek.todoapplication.core.Priority
import dev.fluttycatgeek.todoapplication.core.utils.Constants

@Entity(tableName = Constants.TODO_TABLE)
data class TodoTaskDto(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority

)