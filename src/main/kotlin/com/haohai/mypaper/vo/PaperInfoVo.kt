package com.haohai.mypaper.vo

import java.io.Serializable

/**
 *壁纸详情信息
 **/

data class PaperInfoVo(
    /**
     * 封面壁纸图片
     * @param realImg 参数
     **/
    var imgCover: String? = null,
    /**
     * 壁纸真实图片地址
     * @param realImg 参数
     **/
    var realImg: String? = null,
    /**
     * 壁纸真实标题
     * @param realTitle 参数
     **/
    var realTitle: String? = null,
    /**
     * 壁纸真实大小
     * @param realSize 参数
     **/
    var realSize: String? = null,
    /**
     * 壁纸真实分辨率
     * @param resolution 参数
     **/
    var resolution: String? = null,
    /**
     * 壁纸类别
     * @param category 参数
     **/
    var category: String? = null,
) : Serializable