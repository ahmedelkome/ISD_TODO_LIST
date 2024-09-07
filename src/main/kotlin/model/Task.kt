package model

data class Task(
    val id: Int,
    val description: String,
    var completed: Boolean = false
)
