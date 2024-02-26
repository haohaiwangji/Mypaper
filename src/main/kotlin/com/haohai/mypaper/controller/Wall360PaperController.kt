package com.haohai.mypaper.controller

import com.haohai.mypaper.api.Wall360PaperApi
import com.haohai.mypaper.service.Wall360PaperService


import com.haohai.mypaper.utils.Result
import com.haohai.mypaper.utils.ResultApi
import com.haohai.mypaper.vo.PaperInfoVo

import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.*

/**
 * @folder 360壁纸库
 *
 */
@RestController
@RequestMapping("/wall360")
@CrossOrigin
class Wall360PaperController {


    @Resource
    lateinit var wall360PaperServiceImpl: Wall360PaperService
    
    /**
     *搜索壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getSearchImg")
    fun getSearchImg(@RequestParam("id") pageID: Int,@RequestParam("text") search: String): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.getSearchApi(search) + pageID))
    }
    /**
     *获取首页壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getIndexImg")
    fun getIndexImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        val list = mutableListOf<PaperInfoVo>()
        if(pageID==1){
            val page = arrayOf(-1, 7)
            repeat(2) {
                val newItems = wall360PaperServiceImpl.getBYContentImg(Wall360PaperApi.getBiYingApi + page[it])
                // 假设getContentImg返回的是单个PaperInfoVo或集合类型
                list.addAll(newItems)
            }
            return ResultApi.ok(list)
        }else{
            return ResultApi.ok(list)
        }
    }

    /**
     *获取最近壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getNewImg")
    fun getNewImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperNewesApi + pageID))

    }

    /**
     *获取4k壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/get4kImg")
    fun get4kImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360Paper4kApi + pageID))
    }

    /**
     *获取美女壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getWomanImg")
    fun getWomanImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperWomanApi + pageID))
    }

    /**
     *获取爱情壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getLoveImg")
    fun getLoveImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperLoveApi + pageID))
    }

    /**
     *获取风景壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getSceneryImg")
    fun getSceneryImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperSceneryApi + pageID))
    }

    /**
     *获取小清新壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getFreshnessImg")
    fun getFreshnessImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperFreshnessApi + pageID))
    }

    /**
     *获取动漫壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getAnimeImg")
    fun getAnimeImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperAnimeApi + pageID))
    }

    /**
     *获取明星壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getStarImg")
    fun getStarImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperStarApi + pageID))
    }

    /**
     *获取萌宠壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getPetImg")
    fun getPetImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperPetApi + pageID))
    }

    /**
     *获取游戏壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getGameImg")
    fun getGameImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperGameApi + pageID))
    }

    /**
     *获取汽车壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getCarImg")
    fun getCarImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperCarApi + pageID))
    }

    /**
     *获取时尚壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getVogueImg")
    fun getVogueImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperVogueApi + pageID))
    }

    /**
     *获取月历壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getDateImg")
    fun getDateImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperDateApi + pageID))
    }

    /**
     *获取影视壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getFilmImg")
    fun getFilmImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperFilmApi + pageID))
    }

    /**
     *获取节日壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getFestivalImg")
    fun getFestivalImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperFestivalApi + pageID))
    }

    /**
     *获取军事壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getArmyImg")
    fun getArmyImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperArmyApi + pageID))
    }

    /**
     *获取体育壁纸
     * @param pageID 壁纸页面id
     * @return
     **/
    @GetMapping("/getPhysicalImg")
    fun getPhysicalImg(@RequestParam("id") pageID: Int): Result<List<PaperInfoVo>> {
        return ResultApi.ok(wall360PaperServiceImpl.getContentImg(Wall360PaperApi.Wall360PaperPhysicalApi + pageID))
    }

}