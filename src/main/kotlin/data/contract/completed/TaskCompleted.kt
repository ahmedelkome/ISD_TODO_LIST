package data.contract.completed

import model.Task

interface TaskCompleted {
    fun markAsCompleted(tasks: MutableList<Task>, id: Int)
}