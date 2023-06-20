package dev.fluttycatgeek.todoapplication.core.repository

import dev.fluttycatgeek.todoapplication.core.dao.ToDoDao
import dev.fluttycatgeek.todoapplication.core.dto.TodoTaskDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val toDoDao: ToDoDao
) {

    val getAllTasks: Flow<List<TodoTaskDto>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<TodoTaskDto>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTaskDto>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TodoTaskDto> {
        return toDoDao.getSelectedTasks(taskId)
    }

    suspend fun addTask(todoTask: TodoTaskDto) {
        toDoDao.addTask(todoTask)
    }

    suspend fun updateTask(todoTask: TodoTaskDto) {
        toDoDao.updateTask(todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTaskDto) {
        toDoDao.deleteTask(todoTask)
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<TodoTaskDto>> {
        return toDoDao.searchDatabase(searchQuery)
    }
}