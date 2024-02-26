package com.haohai.mypaper.api

/**
 * Wallhaven壁纸api管理
 */
object WallhavenApi {

    //代理地址
    val HOST = "127.0.0.1"

    //代理端口
    val port = 7890

    //wallhaven基本接口
    val WallhavenBaseurl = "https://wallhaven.cc/api/v1"
    //壁纸详情
    val WallhavenDetailApi = "$WallhavenBaseurl/w/"
    //随机壁纸
    val WallhavenRandomApi = "$WallhavenBaseurl/search?sorting=random&page="

    //最新壁纸（首页）
    val WallhavenLatestApi = "$WallhavenBaseurl/search?order=desc&page="

    //热门壁纸
    val WallhavenhotApi = "$WallhavenBaseurl/search?sorting=toplist&page="

    //搜索
    @JvmStatic
    fun getSearchApi(search: String): String {
        return "$WallhavenBaseurl/search?q=${search}&page="
    }

    //壁纸排行(前一天：1d，上1月：1M，上1周：1w，上1年：1y)
    @JvmStatic
    fun getTopListApi(topRange: String): String {
        return "$WallhavenBaseurl/search?sorting=toplist&topRange=${topRange}&order=desc&page="
    }
    //常规
    val WallhavenCategoriesApi = "$WallhavenBaseurl/search?categories=100&page="

    //动漫
    val WallhavenAnimeApi = "$WallhavenBaseurl/search?categories=010&page="

    //风景
    val WallhavenLandscapeApi = "$WallhavenBaseurl/search?q=landscape&page="

    //汽车
    val WallhavenCarApi = "$WallhavenBaseurl/search?q=car&page="

    //游戏
    val WallhavenGameApi = "$WallhavenBaseurl/search?q=game&page="

    //系统
    val WallhavenSystemApi = "$WallhavenBaseurl/search?q=system&page="
}