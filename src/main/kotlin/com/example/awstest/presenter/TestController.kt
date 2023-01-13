package com.example.awstest.presenter

import com.example.awstest.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService
) {
    @GetMapping("/{id}")
    fun test(@PathVariable("id") id: Long): String? {
        return testService.service(id)
    }

    @GetMapping("/")
    fun update() {
        testService.update()
    }
}
