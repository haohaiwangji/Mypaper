package com.haohai.mypaper.service

import com.haohai.mypaper.vo.PaperInfoVo
import com.haohai.mypaper.vo.PaperVo

/**
 * WallhavenService
 */
interface WallhavenService {
    //获取壁纸
    fun getContentImg(wallHavenApi: String): List<PaperVo>

    //获取真实图片地址
    fun getImgHref(wallHavenHref: String): PaperInfoVo

}