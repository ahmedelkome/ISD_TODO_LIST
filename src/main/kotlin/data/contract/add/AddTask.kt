package data.contract.add

import model.Task

interface AddTask {
    fun addTask(description:String,tasks:MutableList<Task>)
}