//package com.haohai.mypaper.config
//
//import com.haohai.mypaper.utils.Utils
//import jakarta.annotation.PostConstruct
//import org.springframework.stereotype.Component
//
///**
// * StringBoot启动初始化类
// */
//@Component
//class InitConfig {
//
//    @PostConstruct
//    fun initData() {
//        if (Utils.loginUtils()) {
//            println("数据已初始化完成")
//        }else{
//            println("登录失败")
//        }
//    }
//}