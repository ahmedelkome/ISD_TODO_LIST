package services.add

import contract.add.AddTask
import model.Task

class AddTaskImpl : AddTask {
    override fun addTask(description: String, tasks: MutableList<Task>) {
        val id = if (tasks.isEmpty()) 1 else tasks.maxOf {
            it.id
        } + 1
        if (description.isEmpty()){
            println("Please Enter Description")
        }else{
            tasks.add(Task(id,description))
            println("Task Added $description")
        }
    }
}