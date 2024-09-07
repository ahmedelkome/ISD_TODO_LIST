package data.contract.all_task

import model.Task

interface GetAllTask {
    fun getAllTask(tasks: MutableList<Task>)
}