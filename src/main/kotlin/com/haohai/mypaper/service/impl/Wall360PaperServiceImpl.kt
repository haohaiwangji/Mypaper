package com.haohai.mypaper.service.impl

import com.haohai.mypaper.api.Wall360PaperApi
import com.haohai.mypaper.pojo.BirdPaper
import com.haohai.mypaper.pojo.BiyingPaper
import com.haohai.mypaper.pojo.Wall360Paper
import com.haohai.mypaper.service.Wall360PaperService
import com.haohai.mypaper.utils.RequestUtils
import com.haohai.mypaper.vo.PaperInfoVo
import org.springframework.stereotype.Service

/**
 *Wall360PaperServiceImpl壁纸实现类
 **/
@Service
class Wall360PaperServiceImpl: Wall360PaperService {
    override fun getContentImg(wall360PaperApi: String): List<PaperInfoVo> {
        val paperVos = mutableListOf<PaperInfoVo>()
        val wall360Data = RequestUtils.requestUtils(wall360PaperApi, Wall360Paper::class.java, null)
        wall360Data?.data?.forEach {
            //缩略图,图片详情地址
            paperVos.add(PaperInfoVo(it.img1024768, it.url,it.utag, null,it.resolution,null))
        }
        return paperVos
    }

    override fun getBYContentImg(wall360PaperApi: String): List<PaperInfoVo> {
        val paperVos = mutableListOf<PaperInfoVo>()
        val wall360Data = RequestUtils.requestUtils(wall360PaperApi, BiyingPaper::class.java, null)
        wall360Data?.images?.forEach {
            //缩略图,图片详情地址
            val url = Wall360PaperApi.BYBaseurl + it.url
            val imgUrl = url.split("&".toRegex())[0]
            paperVos.add(PaperInfoVo( imgUrl, imgUrl,it.title, null,"1920x1080",null))
        }
        return paperVos
    }
}