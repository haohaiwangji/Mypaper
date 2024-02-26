package com.haohai.mypaper.pojo


import com.google.gson.annotations.SerializedName

data class BiyingPaper(
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("tooltips")
    val tooltips: Tooltips
) {
    data class Image(
        @SerializedName("bot")
        val bot: Int, // 1
        @SerializedName("copyright")
        val copyright: String, // 圣詹姆斯潮汐池，开普敦，南非 (© AmazingAerialAgency/Adobe)
        @SerializedName("copyrightlink")
        val copyrightlink: String, // https://www.bing.com/search?q=%E5%BC%80%E6%99%AE%E6%95%A6&form=hpcapt&mkt=zh-cn
        @SerializedName("drk")
        val drk: Int, // 1
        @SerializedName("enddate")
        val enddate: String, // 20240207
        @SerializedName("fullstartdate")
        val fullstartdate: String, // 202402061600
        @SerializedName("hs")
        val hs: List<Any>,
        @SerializedName("hsh")
        val hsh: String, // 6e81956d2384929d5d6d762536eb9da0
        @SerializedName("quiz")
        val quiz: String, // /search?q=Bing+homepage+quiz&filters=WQOskey:%22HPQuiz_20240206_StJamesPool%22&FORM=HPQUIZ
        @SerializedName("startdate")
        val startdate: String, // 20240206
        @SerializedName("title")
        val title: String, // 海浪中的避风港
        @SerializedName("top")
        val top: Int, // 1
        @SerializedName("url")
        val url: String, // /th?id=OHR.StJamesPool_ZH-CN5930624359_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp
        @SerializedName("urlbase")
        val urlbase: String, // /th?id=OHR.StJamesPool_ZH-CN5930624359
        @SerializedName("wp")
        val wp: Boolean // true
    )

    data class Tooltips(
        @SerializedName("loading")
        val loading: String, // 正在加载...
        @SerializedName("next")
        val next: String, // 下一个图像
        @SerializedName("previous")
        val previous: String, // 上一个图像
        @SerializedName("walle")
        val walle: String, // 此图片不能下载用作壁纸。
        @SerializedName("walls")
        val walls: String // 下载今日美图。仅限用作桌面壁纸。
    )
}