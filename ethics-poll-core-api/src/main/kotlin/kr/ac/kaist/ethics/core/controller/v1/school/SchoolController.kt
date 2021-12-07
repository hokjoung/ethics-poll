package kr.ac.kaist.ethics.core.controller.v1.school

import kr.ac.kaist.ethics.core.controller.v1.school.reqres.NewAnswerRequest
import kr.ac.kaist.ethics.core.controller.v1.school.reqres.NewQuestionRequest
import kr.ac.kaist.ethics.core.controller.v1.school.reqres.QuestionDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/server/api/v1/question")
class SchoolController(
    val service: SchoolService
) {
    @GetMapping(value = ["list"])
    fun list(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse): List<QuestionDto> {
        val res = service.getList()
        if (!servletRequest.cookies.any { it.name == "sessionId" }) {
            servletResponse.addCookie(Cookie("sessionId", UUID.randomUUID().toString()))
        }
        return res
    }

    @PostMapping(value = ["answer"])
    fun newAnswer(servletRequest: HttpServletRequest, @RequestBody req: NewAnswerRequest): Boolean {
        service.newAnswer(servletRequest, req)
        return true
    }

    @PostMapping(value = ["new"])
    fun newQuestion(@RequestBody req: NewQuestionRequest): Boolean {
        service.newQuestion(req)
        return true
    }
}