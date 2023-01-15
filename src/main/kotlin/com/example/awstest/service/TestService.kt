package com.example.awstest.service

import com.example.awstest.jpa.TestEntity
import com.example.awstest.jpa.TestRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TestService(
    private val testRepository: TestRepository,
    private val evictor: CacheEvictor
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
    fun update() {
        val bu  = testRepository.findByName("A")
        evictor.evict(bu!!.id!!)
        bu?.name = "B"
    }
}