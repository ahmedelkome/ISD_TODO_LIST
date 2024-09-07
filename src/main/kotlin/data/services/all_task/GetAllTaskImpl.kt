package data.services.all_task

import data.contract.all_task.GetAllTask
import model.Task
import utils.Constants

class GetAllTaskImpl : GetAllTask {
    override fun getAllTask(tasks: MutableList<Task>) {
        if (tasks.isEmpty()) {
            println(Constants.NO_TASK_AVAILABLE)
        } else {
            tasks.forEach {
                val status = if (it.completed) Constants.COMPLETED else Constants.NOT_COMPLETED
                println("ID : ${it.id} , Description : ${it.description} , Status : $status")
            }
        }
    }
}