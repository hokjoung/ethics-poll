package kr.ac.kaist.ethics.core.controller.v1.school.reqres

data class QuestionDto(
    val id: Long,
    val question: String,
    val option1: String,
    val option2: String,
    val answerStats: AnswerStatDto
)
