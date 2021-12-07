package kr.ac.kaist.ethics.core.controller.v1.school.reqres

data class NewQuestionRequest(
    val question: String,
    val option1: String,
    val option2: String
)
