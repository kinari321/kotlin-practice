package com.example.thymeleafhelloworld.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    // TODO: 不要
    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}