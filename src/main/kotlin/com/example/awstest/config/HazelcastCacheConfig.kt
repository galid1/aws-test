package com.example.awstest.config

import com.hazelcast.config.Config
import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HazelcastCacheConfig {
    @Bean
    fun instance(): HazelcastInstance {
        val config = Config()
            .also {
                it.networkConfig.join.multicastConfig.isEnabled = false
                it.networkConfig.join.awsConfig
                    .also { awsConfig ->
                        awsConfig.isEnabled = true
                        awsConfig.setProperty("tag-key", "hazel")
                    }

            }

        return Hazelcast.newHazelcastInstance(config)
    }
}