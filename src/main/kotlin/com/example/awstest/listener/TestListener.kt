package com.example.awstest.listener

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener

@Configuration
class TestListener(
) {
    @EventListener
    fun service(context: ContextRefreshedEvent) {
        val env = context.applicationContext.environment
        val data = env.getProperty("secret.data")
        println("secret @@@@@@@ : $data")
    }
}