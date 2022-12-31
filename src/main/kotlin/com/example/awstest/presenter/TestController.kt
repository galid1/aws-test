package com.example.awstest.presenter

import com.example.awstest.listener.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val testService: TestService
) {
    @GetMapping("/")
    fun test(): String {
        return testService.service()
    }
}