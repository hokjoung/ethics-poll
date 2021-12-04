package kr.ac.kaist.ethics.core.controller.v1.school

import kr.ac.kaist.ethics.core.controller.v1.school.reqres.AnswerStatDto
import kr.ac.kaist.ethics.core.controller.v1.school.reqres.QuestionDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/server/api/v1/question")
class SchoolController(
    val service: SchoolService
) {
    @GetMapping(value = ["list"])
    fun list(): List<QuestionDto> {
        return listOf(QuestionDto(question = "aaa", option1 = "bbb", option2 = "ccc", answerStats = AnswerStatDto(option1Count = 1, option2Count = 2)))
        /*
        service.getQuestionList()
        servletResponse.addCookie()
         */
    }

    @PostMapping(value = ["answer"])
    fun answer() {
        /*
        service.newAnswer(user, )
         */
    }

    @PostMapping(value = ["new"])
    fun new() {
    }
}