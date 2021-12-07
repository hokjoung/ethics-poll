package kr.ac.kaist.ethics.core.controller.v1.school.reqres

data class NewAnswerRequest(
    val questionId: Long,
    val selection: Int
)
