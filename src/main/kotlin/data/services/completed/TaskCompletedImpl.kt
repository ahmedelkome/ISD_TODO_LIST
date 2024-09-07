package data.services.completed

import data.contract.completed.TaskCompleted
import model.Task
import utils.Constants
import utils.FileOperation

class TaskCompletedImpl(private val fileOperation: FileOperation) : TaskCompleted {
    override fun markAsCompleted(tasks: MutableList<Task>, id: Int) {
        val task = tasks.find { it.id == id }
        if (task != null) {
            task.completed = true
            fileOperation.saveTasksToFile(tasks = tasks, filename = Constants.FILENAME)
            println("Task Marked as Completed ${task.description}")
        } else {
            println(Constants.TASK_NOT_FOUND)
        }
    }
}