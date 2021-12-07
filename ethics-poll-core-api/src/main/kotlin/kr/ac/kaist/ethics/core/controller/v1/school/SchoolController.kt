package kr.ac.kaist.ethics.core.controller.v1.school

import kr.ac.kaist.ethics.core.controller.v1.school.reqres.AnswerRequest
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
    fun list(servletResponse: HttpServletResponse): List<QuestionDto> {
        val res = service.getList()
        servletResponse.addCookie(Cookie("sessionId", UUID.randomUUID().toString()))
        return res
    }

    @PostMapping(value = ["answer"])
    fun answer(servletRequest: HttpServletRequest, @RequestBody req: AnswerRequest) {
        service.newAnswer(servletRequest, req)
    }

    @PostMapping(value = ["new"])
    fun new() {
    }
}