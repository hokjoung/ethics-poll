package kr.ac.kaist.ethics.core.controller.v1.school.reqres

data class AnswerRequest(
    val questionId: Long,
    val selection: Int
)
