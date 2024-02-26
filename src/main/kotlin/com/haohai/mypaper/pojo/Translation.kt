package com.haohai.mypaper.pojo


import com.google.gson.annotations.SerializedName

data class Translation(
    @SerializedName("desc")
    val desc: String, // 中文翻译英文
    @SerializedName("text")
    val text: String, // hello.
    @SerializedName("type")
    val type: String // 中英互译
)