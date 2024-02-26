package com.haohai.mypaper.service.impl

import com.haohai.mypaper.pojo.WallPaper
import com.haohai.mypaper.pojo.WallPaperInfo
import com.haohai.mypaper.service.WallhavenService
import com.haohai.mypaper.utils.RequestUtils
import com.haohai.mypaper.vo.PaperInfoVo
import com.haohai.mypaper.vo.PaperVo
import org.springframework.stereotype.Service


/**
 *Wallhaven壁纸实现类
 **/
@Service
class WallhavenServiceImpl : WallhavenService {
    //获取壁纸
    override fun getContentImg(wallHavenApi: String): List<PaperVo> {
        val PaperVos = mutableListOf<PaperVo>()
        val wallData = RequestUtils.requestWallUtils(wallHavenApi, WallPaper::class.java)
        wallData?.data?.forEach {
            //缩略图,图片详情地址
            PaperVos.add(PaperVo(it.thumbs.small, it.url))
        }
        return PaperVos
    }

    //获取真实图片地址
    override fun getImgHref(wallHavenHref: String): PaperInfoVo {
        val wallDataInfo = RequestUtils.requestWallUtils(wallHavenHref, WallPaperInfo::class.java)
        //计算图片真实大小
        val byteSize = wallDataInfo?.data?.fileSize
        val mbSize = byteSize?.toDouble()?.div((1024 * 1024))
      val formattedMbSize=  String.format("%.2f", mbSize)
        //缩略图,壁纸真实图片地址,壁纸真实标题,壁纸真实大小,壁纸真实分辨率
        return PaperInfoVo(
            wallDataInfo?.data?.thumbs?.small, wallDataInfo?.data?.path,
            null, "$formattedMbSize MB", wallDataInfo?.data?.resolution
        )
    }


}
