package com.haohai.mypaper.vo

import java.io.Serializable

/*
*壁纸信息
*/
data class PaperVo(
    /**
     * 封面壁纸图片
     * @param imgCover 参数
     **/
    var imgCover: String? = null,
    /**
     * 壁纸地址
     * @param imgHref 参数
     **/
    var imgHref: String? = null,
) : Serializable

