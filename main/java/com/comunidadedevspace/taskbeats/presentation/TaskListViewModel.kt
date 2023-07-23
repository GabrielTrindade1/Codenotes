package com.comunidadedevspace.taskbeats.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.comunidadedevspace.taskbeats.Codenotes
import com.comunidadedevspace.taskbeats.data.Task
import com.comunidadedevspace.taskbeats.data.TaskDao

class TaskListViewModel(taskDao: TaskDao) : ViewModel() {

    val taskListLiveData: LiveData<List<Task>> = taskDao.getAll()

    companion object {
        fun create(application: Application): TaskListViewModel {
            val dataBaseInstance = (application as Codenotes).getAppDataBase()
            val dao = dataBaseInstance.taskDao()
            return TaskListViewModel(dao)
        }
    }
}