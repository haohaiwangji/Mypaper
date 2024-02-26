package com.haohai.mypaper.utils

import com.google.gson.Gson
import com.haohai.mypaper.api.WallhavenApi
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.net.InetSocketAddress

/*
 *请求工具类
 *@description
 *@author haohai
 *@version 1.0
 *@create 2024/1/31 14:25
*/
object RequestUtils {
    /**
     *wall请求
     **/
    fun <T> requestWallUtils(url: String, classOfT: Class<T>): T? {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.proxy(
            java.net.Proxy(
                java.net.Proxy.Type.HTTP,
                InetSocketAddress(WallhavenApi.HOST, WallhavenApi.port)
            )
        )
        // 构建 OkHttpClient
        val client = clientBuilder.build()
        val request: Request = Request.Builder()
            .url(url)
            .get()
            .build()
        // 使用 OkHttpClient 发送请求
        val response = client.newCall(request).execute() //获取新的请求
        return Gson().fromJson(response.body?.string(), classOfT)
    }

    /**
     *通用请求
     **/
    fun <T> requestUtils(url: String, classOfT: Class<T>, body: RequestBody?): T? {
        val client = OkHttpClient()
        val request: Request?
        val requestBuilder = Request.Builder().url(url)
        request = when {
            body != null -> {
                requestBuilder.post(body).build()
            }
            else -> {
                // Get请求
                requestBuilder.get().build()
            }
        }
        val response = client.newCall(request).execute()
        return Gson().fromJson(response.body?.string(), classOfT)
    }

}
/**
 * // 使用示例
val requestUtils =
RequestUtils.requestUtils("https://wallhaven.cc/api/v1/search?sorting=random&page=2", WallPaper::class.java)
println(requestUtils)
 **/