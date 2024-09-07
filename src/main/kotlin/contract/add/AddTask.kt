package contract.add

import model.Task

interface AddTask {
    fun addTask(descriptions:String,tasks:MutableList<Task>)
}