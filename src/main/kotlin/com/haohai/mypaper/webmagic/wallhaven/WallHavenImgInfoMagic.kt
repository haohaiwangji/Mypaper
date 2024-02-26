//package com.haohai.mypaper.webmagic.wallhaven
//
//import com.haohai.mypaper.utils.WebMagic
//import com.haohai.mypaper.vo.WallPaperInfo
//import us.codecraft.webmagic.Page
//
//
//class WallHavenImgInfoMagic: WebMagic() {
//    var wallHaven: WallPaperInfo? = null
//    //获取图片信息
//    override fun process(page: Page?) {
//        //实例化wallHaven对象
//        wallHaven = WallPaperInfo()
//        page?.putField("Img", page.html.`$`("section").`$`("div").`$`("img", "src").toString())
//        page?.putField("Resolution",page.html.`$`("aside").`$`("div").`$`("div").`$`("h3","text").toString())
//        page?.putField("realSize",page.html.xpath("//dl[1]/dd[4]/text()").toString())
//        wallHaven?.realImg = page?.resultItems?.get<String>("Img")
//        wallHaven?.resolution = page?.resultItems?.get<String>("Resolution")
//        wallHaven?.realSize = page?.resultItems?.get<String>("realSize")
//    }
//
//
//}