package data.services.remove

import contract.add.remove.RemoveTask
import model.Task
import utils.Constants
import utils.FileOperation

class RemoveTaskImpl(private val fileOperation: FileOperation) : RemoveTask {
    override fun removeTask(id: Int, tasks: MutableList<Task>) {

        val task = tasks.find {
            it.id == id
        }
        if (task != null) {
            tasks.remove(task)
            fileOperation.saveTasksToFile(tasks = tasks, filename = Constants.FILENAME)
            println("Task Removed ${task.description}")
        } else {
            println(Constants.TASK_NOT_FOUND)
        }
    }

    override fun removeTaskByDescription(description: String, tasks: MutableList<Task>) {
        val task = tasks.find { it.description.lowercase() == description.lowercase() }
        if (task != null) {
            tasks.remove(task)
            fileOperation.saveTasksToFile(tasks = tasks, filename = Constants.FILENAME)
            println("Task Removed: ${task.description}")
        } else {
            println(Constants.TASK_NOT_FOUND)
        }
    }
}

