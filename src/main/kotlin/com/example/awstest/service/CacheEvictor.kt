//package com.example.awstest.service
//
//import org.springframework.cache.CacheManager
//import org.springframework.stereotype.Component
//
//@Component
//class CacheEvictor(
//    private val cacheManager: CacheManager
//) {
//    fun evict(id: Long) {
//        cacheManager.getCache("test_cache")
//            ?.run { this.evict(id) }
//    }
//}