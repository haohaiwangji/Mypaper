package com.haohai.mypaper.service

import com.haohai.mypaper.vo.PaperInfoVo

/**
 *Wall360PaperService
 **/
interface Wall360PaperService {
    //获取壁纸
    fun getContentImg(wall360PaperApi: String): List<PaperInfoVo>
    //获取必应壁纸
    fun getBYContentImg(wall360PaperApi: String): List<PaperInfoVo>

}