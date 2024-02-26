//package com.haohai.mypaper.webmagic.wallhaven
//
//import com.haohai.mypaper.utils.WebMagic
//import us.codecraft.webmagic.Page
//
//
///**
// * 随机获取壁纸
// */
//class WallHavenImgMagic : WebMagic() {
//    var wallpaper: WallPaper? = null
//    override fun process(page: Page?) {
//        //实例化wallHaven对象
//        wallpaper = WallPaper()
//        //获取图片
//        page?.putField("ImgCover", page.html.`$`("figure").`$`("img", "data-src").all())
//        //获取进入图片
//        page?.putField("imgHref", page.html.`$`("figure").`$`(".preview", "href").all())
//        //获取图片信息
//        page?.putField("imgContent", page.html.xpath("//figure/div/span[@class='wall-res']/text()").all())
//
//        wallpaper?.cover = page?.resultItems?.get<List<String>>("ImgCover")
//        wallpaper?.imgHref = page?.resultItems?.get<List<String>>("imgHref")
//        wallpaper?.imgContent = page?.resultItems?.get<List<String>>("imgContent")
//    }
//}