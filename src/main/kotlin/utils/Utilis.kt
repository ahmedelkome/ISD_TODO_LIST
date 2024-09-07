package utils

import model.Task
import java.io.File

class FileOperation {
    fun loadTasksFromFile(filename: String): MutableList<Task> {
        val tasks = mutableListOf<Task>()
        val file = File(filename)

        if (file.exists()) {
            file.forEachLine { line ->
                val parts = line.split(",")
                if (parts.size == 3) {
                    val id = parts[0].trim().toInt()
                    val description = parts[1].trim()
                    val completed = parts[2].trim().toBoolean()

                    if (id != null) {
                        tasks.add(Task(id, description, completed))
                    }
                }
            }
        }
        return tasks
    }

    fun saveTasksToFile(tasks: List<Task>, filename: String) {
        val file = File(filename)
        file.printWriter().use { out ->
            tasks.forEach { task ->
                out.println("${task.id}  , ${task.description}  ,${task.completed}")
            }
        }
    }

    fun clearFile(filename: String, tasks: MutableList<Task>) {
        val file = File(filename)
        if (file.exists()) {
            file.writeText("")  // Clear the file content
            println(Constants.FILE_CLEARED)
            tasks.clear()
        } else {
            println(Constants.FILE_NOT_FOUND)
        }
    }
}


