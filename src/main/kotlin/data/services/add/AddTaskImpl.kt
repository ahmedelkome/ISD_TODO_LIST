package data.services.add

import data.contract.add.AddTask
import model.Task
import utils.Constants
import utils.FileOperation

class AddTaskImpl(private val fileOperation: FileOperation) : AddTask {
    override fun addTask(description: String, tasks: MutableList<Task>) {
        val id = if (tasks.isEmpty()) 1 else tasks.maxOf {
            it.id
        } + 1
        if (description.isEmpty()) {
            println(Constants.PLEASE_ENTER_DESCRIPTION)
        } else {
            tasks.add(Task(id, description))
            fileOperation.saveTasksToFile(tasks = tasks, filename = Constants.FILENAME)
            println("Task Added $description")
        }
    }
}