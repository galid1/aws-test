package com.example.awstest.listener

import com.example.awstest.jpa.TestEntity
import com.example.awstest.jpa.TestRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TestService(
    private val testRepository: TestRepository,
) {
    init {
        testRepository.save(TestEntity(name = "A"))
    }

    @Cacheable(cacheNames = ["test_cache"], key = "#name")
    fun service(name: String): String? {
        return testRepository.findByName(name)
            ?.let {
                """
                        id: ${it.id}
                        name: ${it.name}
                    """.trimIndent()
            }
    }

    @Transactional
    fun update() {
        val bu  = testRepository.findByName("A")
        bu?.name = "B"
    }
}