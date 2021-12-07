package kr.ac.kaist.ethics.core.controller.v1.school

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/server/web")
class WebController {
    @GetMapping("/home")
    fun home(model: Model): String {
        return "home"
    }
}