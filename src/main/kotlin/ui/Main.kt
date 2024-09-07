package ui

import data.contract.add.AddTask
import contract.add.remove.RemoveTask
import data.contract.all_task.GetAllTask
import data.contract.completed.TaskCompleted
import data.services.add.AddTaskImpl
import data.services.all_task.GetAllTaskImpl
import data.services.completed.TaskCompletedImpl
import data.services.remove.RemoveTaskImpl
import utils.*

fun main() {
    val fileOperation = FileOperation()
    val addTask: AddTask = AddTaskImpl(fileOperation)
    val removeTask: RemoveTask = RemoveTaskImpl(fileOperation)
    val getAllTask: GetAllTask = GetAllTaskImpl()
    val completedTask: TaskCompleted = TaskCompletedImpl(fileOperation)

    // Load tasks from file: On startup
    val tasks = fileOperation.loadTasksFromFile(Constants.FILENAME)
    if (tasks.isNotEmpty()) {
        println(Constants.TASKS_LOADED_FROM_FILE)
        tasks.forEach { task ->
            val status = if (task.completed) Constants.COMPLETED else Constants.NOT_COMPLETED
            println("ID: ${task.id}, Description: ${task.description}, Status: $status")
        }
    } else {
        println(Constants.NO_TASKS_FOUND)
    }

    while (true) {
        println(Constants.TODO_LIST)
        println(Constants.ADD)
        println(Constants.REMOVE)
        println(Constants.MARK_AS_COMPLETED)
        println(Constants.GET_ALL_TASK)
        println(Constants.CLEAR_ALL)
        println(Constants.EXIT)

        when (readLine()) {
            "1" -> {
                print(Constants.ENTER_TASK_DESCRIPTION)
                val description = readLine() ?: ""
                addTask.addTask(tasks = tasks, description = description)
            }

            "2" -> {
                print(Constants.ENTER_TASK_ID)
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    removeTask.removeTask(id = id, tasks = tasks)
                } else {
                    println(Constants.INVALID_ID)
                }
            }

            "3" -> {
                print(Constants.ENTER_TASK_ID)
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    completedTask.markAsCompleted(tasks = tasks, id = id)
                } else {
                    println(Constants.INVALID_ID)
                }
            }

            "4" -> getAllTask.getAllTask(tasks = tasks)

            "5" -> fileOperation.clearFile(Constants.FILENAME, tasks = tasks)

            "6" -> {
                println(Constants.TASKS_SAVED_EXITING)
                break
            }

            else -> println(Constants.INVALID_OPTION)
        }
    }
}