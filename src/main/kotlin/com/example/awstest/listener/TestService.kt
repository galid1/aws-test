package com.example.awstest.listener

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TestService(
    @Value("\${secret.data}")
    var secretData: String?,
) {
    fun service() {
        println("secret @@@@@@@ : ${secretData}")
    }
}