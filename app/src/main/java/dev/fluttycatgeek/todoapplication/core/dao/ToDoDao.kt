package dev.fluttycatgeek.todoapplication.core.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import dev.fluttycatgeek.todoapplication.core.dto.TodoTaskDto
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_task_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<TodoTaskDto>>

    @Query("SELECT * FROM todo_task_table WHERE id=:taskId")
    fun getSelectedTasks(taskId: Int): Flow<TodoTaskDto>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoTaskDto: TodoTaskDto)

    @Update
    suspend fun updateTask(todoTaskDto: TodoTaskDto)

    @Delete
    suspend fun deleteTask(todoTaskDto: TodoTaskDto)

    @Query("DELETE FROM todo_task_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM todo_task_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<TodoTaskDto>>

    @Query("SELECT * FROM todo_task_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<TodoTaskDto>>

    @Query("SELECT * FROM todo_task_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<TodoTaskDto>>
}