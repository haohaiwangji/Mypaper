package com.haohai.mypaper.pojo


import com.google.gson.annotations.SerializedName

data class Wall360Paper(
    @SerializedName("consume")
    val consume: String, // 213
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("errmsg")
    val errmsg: String, // 正常
    @SerializedName("errno")
    val errno: String, // 0
    @SerializedName("total")
    val total: String // 3558
) {
    data class Data(
        @SerializedName("ad_id")
        val adId: String,
        @SerializedName("ad_img")
        val adImg: String,
        @SerializedName("ad_pos")
        val adPos: String,
        @SerializedName("ad_url")
        val adUrl: String,
        @SerializedName("class_id")
        val classId: String, // 36
        @SerializedName("create_time")
        val createTime: String, // 2022-01-18 19:55:47
        @SerializedName("download_times")
        val downloadTimes: String, // 0
        @SerializedName("ext_1")
        val ext1: String,
        @SerializedName("ext_2")
        val ext2: String,
        @SerializedName("id")
        val id: String, // 2054207
        @SerializedName("img_1024_768")
        val img1024768: String, // http://p5.qhimg.com/bdm/1024_768_85/t01b973f01988d074d9.jpg
        @SerializedName("img_1280_1024")
        val img12801024: String, // http://p5.qhimg.com/bdm/1280_1024_85/t01b973f01988d074d9.jpg
        @SerializedName("img_1280_800")
        val img1280800: String, // http://p5.qhimg.com/bdm/1280_800_85/t01b973f01988d074d9.jpg
        @SerializedName("img_1366_768")
        val img1366768: String, // http://p5.qhimg.com/bdm/1366_768_85/t01b973f01988d074d9.jpg
        @SerializedName("img_1440_900")
        val img1440900: String, // http://p5.qhimg.com/bdm/1440_900_85/t01b973f01988d074d9.jpg
        @SerializedName("img_1600_900")
        val img1600900: String, // http://p5.qhimg.com/bdm/1600_900_85/t01b973f01988d074d9.jpg
        @SerializedName("imgcut")
        val imgcut: String, // 0
        @SerializedName("rdata")
        val rdata: List<Any>,
        @SerializedName("resolution")
        val resolution: String, // 3840x2160
        @SerializedName("tag")
        val tag: String, // _全部_ _category_变形金刚_  _category_大黄蜂_  _category_汽车人_  _category_4K专区_
        @SerializedName("tempdata")
        val tempdata: String,
        @SerializedName("update_time")
        val updateTime: String, // 2022-01-18 19:57:04
        @SerializedName("url")
        val url: String, // http://p5.qhimg.com/bdr/__85/t01b973f01988d074d9.jpg
        @SerializedName("url_mid")
        val urlMid: String, // http://p5.qhimg.com/bdr/__85/t01b973f01988d074d9.jpg
        @SerializedName("url_mobile")
        val urlMobile: String,
        @SerializedName("url_thumb")
        val urlThumb: String, // http://p5.qhimg.com/bdr/__85/t01b973f01988d074d9.jpg
        @SerializedName("utag")
        val utag: String // 变形金刚 大黄蜂 汽车人
    )
}