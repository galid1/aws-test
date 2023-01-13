package com.example.awstest.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository: JpaRepository<TestEntity, Long> {
    fun findByName(name: String): TestEntity?
}