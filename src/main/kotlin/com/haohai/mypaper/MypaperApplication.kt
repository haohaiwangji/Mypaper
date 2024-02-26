package com.haohai.mypaper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MypaperApplication
fun main(args: Array<String>) {
    runApplication<MypaperApplication>(*args)
//    System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
//    println("druid："+"http://localhost:8080/druid/index.html");
    println("Api："+"https://apifox.com/apidoc/shared-122aeb8b-9aed-4864-a167-f8419f2489b1")
}