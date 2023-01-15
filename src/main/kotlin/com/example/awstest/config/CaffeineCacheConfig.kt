//package com.example.awstest.config
//
//import com.github.benmanes.caffeine.cache.Caffeine
//import org.springframework.cache.CacheManager
//import org.springframework.cache.annotation.EnableCaching
//import org.springframework.cache.caffeine.CaffeineCacheManager
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import java.util.concurrent.TimeUnit
//
//@Configuration
//@EnableCaching
//class CaffeineCacheConfig {
//    @Bean
//    fun caffeineConfig(): Caffeine<Any, Any> {
//        return Caffeine.newBuilder()
//            .maximumSize(200_000)
//    }
//
//    @Bean
//    fun cacheManager(caffeine: Caffeine<Any, Any>): CacheManager {
//        return CaffeineCacheManager()
//            .also { it.setCaffeine(caffeine) }
//    }
//}