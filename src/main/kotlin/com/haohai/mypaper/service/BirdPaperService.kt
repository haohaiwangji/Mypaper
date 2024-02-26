package com.haohai.mypaper.service

import com.haohai.mypaper.vo.PaperInfoVo


/**
 *BirdPaperService
 **/
interface BirdPaperService {
    //获取壁纸
    fun getContentImg(birdPaperApi: String): List<PaperInfoVo>
}