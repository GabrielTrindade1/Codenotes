package com.comunidadedevspace.taskbeats.presentation

import com.comunidadedevspace.taskbeats.data.Task
import java.io.Serializable

enum class ActionType {
    DELETE,
    DELETE_ALL,
    UPDATE,
    CREATE
}

data class TaskAction(
    val task: Task?,
    val actionType: String
) : Serializable