package kr.ac.kaist.ethics.db.core.school

data class Answer(
    val id: Long = 0L,
    val refQuestionId: Long,
    val clientId: String?,
    val selection: Int
)
