package kr.ac.kaist.ethics.core.controller.v1.school

import kr.ac.kaist.ethics.core.controller.v1.school.reqres.AnswerRequest
import kr.ac.kaist.ethics.core.controller.v1.school.reqres.AnswerStatDto
import kr.ac.kaist.ethics.core.controller.v1.school.reqres.QuestionDto
import kr.ac.kaist.ethics.db.core.school.Answer
import kr.ac.kaist.ethics.db.core.school.AnswerRepository
import kr.ac.kaist.ethics.db.core.school.QuestionRepository
import org.springframework.stereotype.Service
import javax.servlet.http.HttpServletRequest

@Service
class SchoolService(
    val questionRepo: QuestionRepository,
    val answerRepo: AnswerRepository
) {
    fun getList(): List<QuestionDto> {
        val questionList = questionRepo.findAll()
        val answerList = answerRepo.findAll()
        return questionList.map { question ->
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

    fun newAnswer(servletRequest: HttpServletRequest, req: AnswerRequest) {
        val sessionId = servletRequest.cookies.find { it.name == "sessionId" }?.value
        if (sessionId != null && answerRepo.findFirstByRefQuestionIdAndClientId(req.questionId, sessionId) != null) {
            throw ServiceException("이미 답변을 남기셨습니다.")
        }
        answerRepo.save(
            Answer(
                refQuestionId = req.questionId,
                clientId = sessionId,
                selection = req.selection
            )
        )
    }


}