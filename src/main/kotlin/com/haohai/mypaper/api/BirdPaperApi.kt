package com.haohai.mypaper.api

/**
 * 360壁纸api管理
 */
object BirdPaperApi {
    //birdpaper基本接口
    val BirdBaseurl = "http://wp.birdpaper.com.cn/intf"

    //返回数量
    val BirdCount = 24

    //最新壁纸
    val BirdNewesApi = "$BirdBaseurl/newestList?count=$BirdCount&pageno="

    //搜索壁纸
    @JvmStatic
    fun getSearchApi(search: String): String {
        return "$BirdBaseurl/search?count=$BirdCount&content=${search}&pageno="
    }

    //4k专区
    val Bird4kApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=36&pageno="


    //美女
    val BirdWomanApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=6&pageno="

    //爱情
    val BirdLoveApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=30&pageno="

    //风景
    val BirdSceneryApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=9&pageno="

    //小清新
    val BirdFreshnessApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=15&pageno="

    //动漫
    val BirdAnimeApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=26&pageno="

    //明星
    val BirdStarApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=11&pageno="

    //萌宠
    val BirdPetApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=14&pageno="

    //游戏
    val BirdGameApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=5&pageno="

    //汽车
    val BirdCarApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=12&pageno="

    //时尚
    val BirdVogueApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=10&pageno="

    //月历
    val BirdDateApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=29&pageno="

    //影视
    val BirdFilmApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=7&pageno="

    //节日
    val BirdFestivalApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=13&pageno="

    //军事
    val BirdArmyApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=22&pageno="

    //体育
    val BirdPhysicalApi = "$BirdBaseurl/GetListByCategory?count=$BirdCount&cids=16&pageno="


}
