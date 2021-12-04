package kr.ac.kaist.ethics.core.controller.v1.school

import kr.ac.kaist.ethics.db.core.school.AnswerRepository
import kr.ac.kaist.ethics.db.core.school.QuestionRepository
import org.springframework.stereotype.Service

@Service
class SchoolService(
    val questionRepo: QuestionRepository,
    val answerRepo: AnswerRepository
) {

}