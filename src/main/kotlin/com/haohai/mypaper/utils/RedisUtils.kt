//package com.haohai.mypaper.utils
//
//import jakarta.annotation.Resource
//import org.springframework.data.redis.core.RedisTemplate
//import org.springframework.stereotype.Component
//
//
//@Component
//class RedisUtils {
//    @Resource
//    lateinit var redisTemplate: RedisTemplate<Any, Any>
//
//
//    /**
//     * 获取指定缓存对象
//     *
//     * @param key 键
//     * @return any 值对象
//     */
//    fun <T : Any> getT(key: String):T? {
//        @Suppress("UNCHECKED_CAST")
//        return  redisTemplate.opsForValue().get(key) as? T
//    }
//
//    /**
//     * 获取long值
//     *
//     * @param key 键
//     * @return any 值对象
//     */
//    fun getLong(key: String):Long?{
//        val value = getAny(key)
//        return when(value){
//            is Byte -> value.toLong()
//            is Int -> value.toLong()
//            is Long -> value
//            is Float -> value.toLong()
//            is Double -> value.toLong()
//            is Char -> value.code.toLong()
//            is String -> value.toLongOrNull()
//            else -> null
//        }
//    }
//
//    /**
//     * 获取int值
//     *
//     * @param key 键
//     * @return any 值对象
//     */
//    fun getInt(key: String):Int?{
//        val value = getAny(key)
//        return when(value){
//            is Byte -> value.toInt()
//            is Int -> value
//            is Long -> value.toInt()
//            is Float -> value.toInt()
//            is Double -> value.toInt()
//            is Char -> value.code
//            is String -> value.toIntOrNull()
//            else -> null
//        }
//    }
//
//    /**
//     * 存入普通缓存对象
//     *
//     * @param key 键
//     * @param value 值对象
//     * @return Boolean 是否成功
//     */
//    fun setAny(key:String,value:Any) {
//        redisTemplate.opsForValue().set(key,value)
//    }
//
//    /**
//     * 删除普通缓存对象
//     *
//     * @param key 键
//     * @return Boolean 是否成功
//     */
//    fun delete(key:String):Boolean {
//        return redisTemplate.delete(key)
//    }
//
//    /**
//     * 获取普通缓存对象
//     *
//     * @param key 键
//     * @return any 值对象
//     */
//     fun getAny(key: String):Any? {
//        return redisTemplate.opsForValue().get(key)
//    }
//}