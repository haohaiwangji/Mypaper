package com.haohai.mypaper.utils

import us.codecraft.webmagic.Page
import us.codecraft.webmagic.ResultItems
import us.codecraft.webmagic.Site
import us.codecraft.webmagic.Task
import us.codecraft.webmagic.pipeline.Pipeline
import us.codecraft.webmagic.processor.PageProcessor

/**
 * 封装爬虫工具类
 */
open class WebMagic : PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private val site = Site.me().setRetryTimes(2).setSleepTime(500)
        .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")

    //部分二：爬虫核心部分
    override fun process(page: Page?){}

    //部分三：返回配置信息
    override fun getSite(): Site = site

}