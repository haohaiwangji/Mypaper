package com.haohai.mypaper.service.impl

import com.haohai.mypaper.pojo.BirdPaper
import com.haohai.mypaper.service.BirdPaperService
import com.haohai.mypaper.utils.RequestUtils
import com.haohai.mypaper.vo.PaperInfoVo
import org.springframework.stereotype.Service

/**
 *SimpleWallpaper壁纸实现类
 **/
@Service
class BirdPaperServiceImpl : BirdPaperService {
    override fun getContentImg(birdPaperApi: String): List<PaperInfoVo> {
        val paperVos = mutableListOf<PaperInfoVo>()
        val birdData = RequestUtils.requestUtils(birdPaperApi, BirdPaper::class.java, null)
        birdData?.data?.list?.forEach {
            //缩略图,图片详情地址
            paperVos.add(PaperInfoVo(it.url, it.url,it.tag, null,null,it.category))
        }
        return paperVos
    }
}

