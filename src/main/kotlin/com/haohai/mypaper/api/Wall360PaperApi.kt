package com.haohai.mypaper.api

/**
 * 360壁纸api管理
 */
object Wall360PaperApi {
    //必应
    val BYBaseurl = "http://cn.bing.com"
    val getBiYingApi="$BYBaseurl/HPImageArchive.aspx?format=js&n=8&idx="

    // Wall360Paper基本接口
    val Wall360PaperBaseurl = "http://wallpaper.apc.360.cn/index.php?c=WallPaper"

    //返回数量
    val Wall360PaperCount = 24


    //最新壁纸
    val Wall360PaperNewesApi =
        "$Wall360PaperBaseurl&a=getAppsByOrder&order=create_time&count=8&from=360chrome&start="

    /**
     *http://wallpaper.apc.360.cn/index.php?c=WallPaper
     * http://wallpaper.apc.360.cn/index.php?c=WallPaper&a=getAppsByCategory&cid=36&start=1&count=10&from=360chrome
     **/
    //搜索壁纸
    @JvmStatic
    fun getSearchApi(search: String): String {
        return "${BirdPaperApi.BirdBaseurl}/search?count=${BirdPaperApi.BirdCount}&content=${search}&pageno="
    }

    //4k专区
    val Wall360Paper4kApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=36&from=360chrome&start="


    //美女
    val Wall360PaperWomanApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=6&from=360chrome&start="

    //爱情
    val Wall360PaperLoveApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=30&from=360chrome&start="

    //风景
    val Wall360PaperSceneryApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=9&from=360chrome&start="

    //小清新
    val Wall360PaperFreshnessApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=15&from=360chrome&start="

    //动漫
    val Wall360PaperAnimeApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=26&from=360chrome&start="

    //明星
    val Wall360PaperStarApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=11&from=360chrome&start="

    //萌宠
    val Wall360PaperPetApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=14&from=360chrome&start="

    //游戏
    val Wall360PaperGameApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=5&from=360chrome&start="

    //汽车
    val Wall360PaperCarApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=12&from=360chrome&start="

    //时尚
    val Wall360PaperVogueApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=10&from=360chrome&start="

    //月历
    val Wall360PaperDateApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=29&from=360chrome&start="

    //影视
    val Wall360PaperFilmApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=7&from=360chrome&start="

    //节日
    val Wall360PaperFestivalApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=13&from=360chrome&start="

    //军事
    val Wall360PaperArmyApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=22&from=360chrome&start="

    //体育
    val Wall360PaperPhysicalApi = "$Wall360PaperBaseurl&a=getAppsByCategory&count=$Wall360PaperCount&cid=16&from=360chrome&start="


}