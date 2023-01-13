package com.example.awstest.presenter

import com.example.awstest.listener.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService
) {
    @GetMapping("/{name}")
    fun test(@PathVariable("name") name: String): String? {
        return testService.service(name)
    }

    @GetMapping("/")
    fun update() {
        testService.update()
    }
}
