package kr.ac.kaist.ethics.db.core.school

data class Question(
    val id: Long = 0L,
    val question: String,
    val option1: String,
    val option2: String
)
