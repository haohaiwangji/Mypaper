package com.haohai.mypaper.pojo


import com.google.gson.annotations.SerializedName

data class WallPaper(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("meta")
    val meta: Meta
) {
    data class Data(
        @SerializedName("category")
        val category: String, // general
        @SerializedName("colors")
        val colors: List<String>,
        @SerializedName("created_at")
        val createdAt: String, // 2014-10-16 14:34:18
        @SerializedName("dimension_x")
        val dimensionX: Int, // 1366
        @SerializedName("dimension_y")
        val dimensionY: Int, // 768
        @SerializedName("favorites")
        val favorites: Int, // 4
        @SerializedName("file_size")
        val fileSize: Int, // 99274
        @SerializedName("file_type")
        val fileType: String, // image/jpeg
        @SerializedName("id")
        val id: String, // 4vqko5
        @SerializedName("path")
        val path: String, // https://w.wallhaven.cc/full/4v/wallhaven-4vqko5.jpg
        @SerializedName("purity")
        val purity: String, // sfw
        @SerializedName("ratio")
        val ratio: String, // 1.78
        @SerializedName("resolution")
        val resolution: String, // 1366x768
        @SerializedName("short_url")
        val shortUrl: String, // https://whvn.cc/4vqko5
        @SerializedName("source")
        val source: String,
        @SerializedName("thumbs")
        val thumbs: Thumbs,
        @SerializedName("url")
        val url: String, // https://wallhaven.cc/w/4vqko5
        @SerializedName("views")
        val views: Int // 3287
    ) {
        data class Thumbs(
            @SerializedName("large")
            val large: String, // https://th.wallhaven.cc/lg/4v/4vqko5.jpg
            @SerializedName("original")
            val original: String, // https://th.wallhaven.cc/orig/4v/4vqko5.jpg
            @SerializedName("small")
            val small: String // https://th.wallhaven.cc/small/4v/4vqko5.jpg
        )
    }

    data class Meta(
        @SerializedName("current_page")
        val currentPage: Int, // 2
        @SerializedName("last_page")
        val lastPage: Int, // 18912
        @SerializedName("per_page")
        val perPage: Int, // 24
        @SerializedName("query")
        val query: Any, // null
        @SerializedName("seed")
        val seed: String, // xyQrTc
        @SerializedName("total")
        val total: Int // 453871
    )
}