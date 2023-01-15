package com.example.awstest.service

import com.example.awstest.jpa.TestEntity
import com.example.awstest.jpa.TestRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TestService(
    private val testRepository: TestRepository,
//    private val evictor: CacheEvictor
) {
    init {
        testRepository.save(TestEntity(name = "A"))
    }

    @Cacheable(cacheNames = ["test_cache"], key = "#id")
    fun service(id: Long): String? {
        println("no cache !")

        return testRepository.findById(id)
            .get()
            ?.let {
                """
                        id: ${it.id}
                        name: ${it.name}
                    """.trimIndent()
            }
    }

    @Transactional
    @CacheEvict(cacheNames = ["test_cache"], key = "#id")
    fun update(id: Long) {
        val bu  = testRepository.findById(id)
            .get()
        bu.name = "B"
    }
}