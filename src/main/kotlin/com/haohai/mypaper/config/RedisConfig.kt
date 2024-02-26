//package com.haohai.mypaper.config
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect
//import com.fasterxml.jackson.annotation.PropertyAccessor
//import com.fasterxml.jackson.databind.ObjectMapper
//import org.springframework.cache.annotation.CachingConfigurerSupport
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.redis.connection.RedisConnectionFactory
//import org.springframework.data.redis.core.RedisTemplate
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
//import org.springframework.data.redis.serializer.StringRedisSerializer
//
//@Configuration
//class RedisConfig: CachingConfigurerSupport() {
//
//    @Bean(value = ["redisTemplate"])
//    fun redisTemplate(factory : RedisConnectionFactory) : RedisTemplate<Any, Any> {
//        val mapper = ObjectMapper()
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
//        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
//        jackson2JsonRedisSerializer.setObjectMapper(mapper)
//        val stringRedisSerializer = StringRedisSerializer()
//        val template = RedisTemplate<Any, Any>()
//        template.setConnectionFactory(factory)
//        template.keySerializer = stringRedisSerializer
//        template.hashKeySerializer = stringRedisSerializer
//        template.valueSerializer = jackson2JsonRedisSerializer
//        template.hashValueSerializer = jackson2JsonRedisSerializer
//        template.afterPropertiesSet()
//        return template
//    }
//
//}