package kr.ac.kaist.ethics.core.controller.v1.school

import kr.ac.kaist.ethics.core.controller.v1.school.reqres.AnswerStatDto
import kr.ac.kaist.ethics.core.controller.v1.school.reqres.QuestionDto
import kr.ac.kaist.ethics.db.core.school.AnswerRepository
import kr.ac.kaist.ethics.db.core.school.QuestionRepository
import org.springframework.stereotype.Service

@Service
class SchoolService(
    val questionRepo: QuestionRepository,
    val answerRepo: AnswerRepository
) {
    fun getList(): List<QuestionDto> {
        val questionList = questionRepo.findAll()
        val answerList = answerRepo.findAll()
        questionList.map { question ->
            val answersForQuestion = answerList.filter { it.refQuestionId == question.id }
            QuestionDto(
                question = question.question,
                option1 = question.option1,
                option2 = question.option2,
                answerStats = AnswerStatDto(
                    option1Count = answersForQuestion.count { it.selection == 1 },
                    option2Count = answersForQuestion.count { it.selection == 2 }
                )
            )
        }
    }


}