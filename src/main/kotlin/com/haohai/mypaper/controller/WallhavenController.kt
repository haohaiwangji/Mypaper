package com.haohai.mypaper.controller

import com.haohai.mypaper.api.GeneralApi
import com.haohai.mypaper.api.WallhavenApi
import com.haohai.mypaper.pojo.Translation
import com.haohai.mypaper.service.WallhavenService
import com.haohai.mypaper.utils.RequestUtils
import com.haohai.mypaper.utils.Result
import com.haohai.mypaper.utils.ResultApi
import com.haohai.mypaper.vo.PaperInfoVo
import com.haohai.mypaper.vo.PaperVo
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.*

/**
 * @folder WakkHaven壁纸库
 *
 */
@RestController
@RequestMapping("/wall")
@CrossOrigin
class WallhavenController {


    @Resource
    lateinit var wallhavenServiceImpl: WallhavenService

    /**
     *获取壁纸排行(1y:去年)
     * @param topRange 排行标识(1y:去年,6M:过去6个月,3M:过去三个月,1M:上个月,1w:上个星期,3d:前三天,1d:前一天)
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getTopListImg")
    fun getTopListImg(
        @RequestParam("topRange") topRange: String,
        @RequestParam("id") pageID: Int,
    ): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.getTopListApi(topRange) + pageID))
    }

    /**
     *获取壁纸详情
     * @param href 地址
     * @return
     **/
    @GetMapping("/getImgInfo")
    fun getImgInfo(@RequestParam("imghref") href: String): Result<PaperInfoVo> {
        return ResultApi.ok(wallhavenServiceImpl.getImgHref(WallhavenApi.WallhavenDetailApi + href.split("/").last()))
    }

    /**
     *获取随机壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getIndexImg")
    fun getRandomImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenRandomApi + pageID))
    }

    /**
     *获取搜索壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getSearchImg")
    fun getSearchImg(@RequestParam("id") pageID: Int, @RequestParam("text") Search: String): Result<List<PaperVo>> {
        //处理中文转英文
        val TranslationData = RequestUtils.requestUtils(GeneralApi.Translation+Search, Translation::class.java,null)
        return ResultApi.ok(wallhavenServiceImpl.getContentImg( TranslationData?.text?.let {
            WallhavenApi.getSearchApi(
                it
            )
        }  + pageID))
    }


    /**
     *获取最新壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getLatestImg")
    fun getLatestImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenLatestApi + pageID))
    }

    /**
     *获取热门壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getHotImg")
    fun getHotImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenhotApi + pageID))
    }

    /**
     *获取常规壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getCategoriesImg")
    fun getCategoriesImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenCategoriesApi + pageID))
    }

    /**
     *获取动漫壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getAnimeImg")
    fun getAnimeImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenAnimeApi + pageID))
    }

    /**
     *获取风景壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getLandscapeImg")
    fun getLandscapeImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenLandscapeApi + pageID))
    }

    /**
     *获取汽车壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getCarImg")
    fun getCarImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenCarApi + pageID))
    }

    /**
     *获取游戏壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getGameImg")
    fun getGameImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenGameApi + pageID))
    }

    /**
     *获取系统壁纸
     * @param pageID 页面id
     * @return
     **/
    @GetMapping("/getSystemImg")
    fun getSystemImg(@RequestParam("id") pageID: Int): Result<List<PaperVo>> {
        return ResultApi.ok(wallhavenServiceImpl.getContentImg(WallhavenApi.WallhavenSystemApi + pageID))
    }

}