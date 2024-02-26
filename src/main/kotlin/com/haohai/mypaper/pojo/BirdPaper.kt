package com.haohai.mypaper.pojo


import com.google.gson.annotations.SerializedName

data class BirdPaper(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("errno")
    val errno: Int, // 0
    @SerializedName("msg")
    val msg: String,
    @SerializedName("processTime")
    val processTime: Double // 0.0006
) {
    data class Data(
        @SerializedName("count")
        val count: Int, // 10
        @SerializedName("list")
        val list: List<lists>,
        @SerializedName("pageno")
        val pageno: Int, // 1
        @SerializedName("total_count")
        val totalCount: Int, // 180
        @SerializedName("total_page")
        val totalPage: Int // 18
    ) {
        data class lists(
            @SerializedName("category")
            val category: String, // 小清新
            @SerializedName("class_id")
            val classId: String, // 15
            @SerializedName("id")
            val id: String, // 2061212
            @SerializedName("live_open")
            val liveOpen: Boolean, // false
            @SerializedName("status")
            val status: String, // 1
            @SerializedName("tag")
            val tag: String, // 鸟语花香,樱花,枝头,天空
            @SerializedName("url")
            val url: String // http://cdn-hw-static2.shanhutech.cn/bizhi/staticwp/202401/6bc376ae2b660ed6e9310ad69bc07f2b--130140516.jpg
        )
    }
}