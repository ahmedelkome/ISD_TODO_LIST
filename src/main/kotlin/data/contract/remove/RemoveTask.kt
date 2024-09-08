package contract.add.remove

import model.Task

interface RemoveTask {
    fun removeTask(id: Int, tasks: MutableList<Task>)

    fun removeTaskByDescription(description: String, tasks: MutableList<Task>)
}