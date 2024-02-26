package com.haohai.mypaper

import com.haohai.mypaper.service.impl.WallhavenServiceImpl
import jakarta.annotation.Resource
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MypaperApplicationTests {

    @Resource
    lateinit var WallhavenService: WallhavenServiceImpl

    @Test
    fun test1() {
      println(  WallhavenService.getImgHref("https://wallhaven.cc/w/k9pmw6"))
    }
}
