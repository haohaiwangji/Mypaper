package com.haohai.mypaper.controller

import com.haohai.mypaper.api.BirdPaperApi
import com.haohai.mypaper.service.BirdPaperService


import com.haohai.mypaper.utils.Result
import com.haohai.mypaper.utils.ResultApi
import com.haohai.mypaper.vo.PaperInfoVo

import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.*

/**
 * @folder 小鸟壁纸库
 *
 */
@RestController
@RequestMapping("/bird")
@CrossOrigin
class BirdPaperController {


    @Resource
    lateinit var birdPaperServiceImpl: BirdPaperService

//    /**
//     *获取壁纸详页面
//     * @param href 壁纸详页面地址
//     * @return String
//     **/
//    @GetMapping("/getImgInfo")
//    fun getImgHref(@RequestParam("imghref") href: String): Result<WallPaperInfo> {
//        return ResultApi.ok(simpleWallpaperServiceImpl.getImgHref(href))
//    }
    /**
     *搜索壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getSearchImg")
    fun getSearchImg(@RequestParam("id") pageID: Int,@RequestParam("text") search: String): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.getSearchApi(search) + pageID))
    }
    /**
     *获取首页壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getIndexImg")
    fun getIndexImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdNewesApi + pageID))
    }

    /**
     *获取4k壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/get4kImg")
    fun get4kImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.Bird4kApi + pageID))
    }

    /**
     *获取美女壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getWomanImg")
    fun getWomanImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdWomanApi + pageID))
    }

    /**
     *获取爱情壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getLoveImg")
    fun getLoveImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdLoveApi + pageID))
    }

    /**
     *获取风景壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getSceneryImg")
    fun getSceneryImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdSceneryApi + pageID))
    }

    /**
     *获取小清新壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getFreshnessImg")
    fun getFreshnessImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdFreshnessApi + pageID))
    }

    /**
     *获取动漫壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getAnimeImg")
    fun getAnimeImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdAnimeApi + pageID))
    }

    /**
     *获取明星壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getStarImg")
    fun getStarImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdStarApi + pageID))
    }

    /**
     *获取萌宠壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getPetImg")
    fun getPetImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdPetApi + pageID))
    }

    /**
     *获取游戏壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getGameImg")
    fun getGameImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdGameApi + pageID))
    }

    /**
     *获取汽车壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getCarImg")
    fun getCarImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdCarApi + pageID))
    }

    /**
     *获取时尚壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getVogueImg")
    fun getVogueImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdVogueApi + pageID))
    }

    /**
     *获取月历壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getDateImg")
    fun getDateImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdDateApi + pageID))
    }

    /**
     *获取影视壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getFilmImg")
    fun getFilmImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdFilmApi + pageID))
    }

    /**
     *获取节日壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getFestivalImg")
    fun getFestivalImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdFestivalApi + pageID))
    }

    /**
     *获取军事壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getArmyImg")
    fun getArmyImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdArmyApi + pageID))
    }

    /**
     *获取体育壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getPhysicalImg")
    fun getPhysicalImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(birdPaperServiceImpl.getContentImg(BirdPaperApi.BirdPhysicalApi + pageID))
    }

}