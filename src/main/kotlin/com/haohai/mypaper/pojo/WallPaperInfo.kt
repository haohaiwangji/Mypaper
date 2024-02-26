package com.haohai.mypaper.pojo


import com.google.gson.annotations.SerializedName

data class WallPaperInfo(
    @SerializedName("data")
    val `data`: Data
) {
    data class Data(
        @SerializedName("category")
        val category: String, // general
        @SerializedName("colors")
        val colors: List<String>,
        @SerializedName("created_at")
        val createdAt: String, // 2024-01-06 14:08:44
        @SerializedName("dimension_x")
        val dimensionX: Int, // 3840
        @SerializedName("dimension_y")
        val dimensionY: Int, // 2160
        @SerializedName("favorites")
        val favorites: Int, // 380
        @SerializedName("file_size")
        val fileSize: Int, // 2649255
        @SerializedName("file_type")
        val fileType: String, // image/jpeg
        @SerializedName("id")
        val id: String, // exrqrr
        @SerializedName("path")
        val path: String, // https://w.wallhaven.cc/full/ex/wallhaven-exrqrr.jpg
        @SerializedName("purity")
        val purity: String, // sfw
        @SerializedName("ratio")
        val ratio: String, // 1.78
        @SerializedName("resolution")
        val resolution: String, // 3840x2160
        @SerializedName("short_url")
        val shortUrl: String, // https://whvn.cc/exrqrr
        @SerializedName("source")
        val source: String,
        @SerializedName("tags")
        val tags: List<Tag>,
        @SerializedName("thumbs")
        val thumbs: Thumbs,
        @SerializedName("uploader")
        val uploader: Uploader,
        @SerializedName("url")
        val url: String, // https://wallhaven.cc/w/exrqrr
        @SerializedName("views")
        val views: Int // 34517
    ) {
        data class Tag(
            @SerializedName("alias")
            val alias: String, // Cgi, digital, Digital 2D, digital artwork, digital compositions, graphic, graphics, Motion Design
            @SerializedName("category")
            val category: String, // Digital
            @SerializedName("category_id")
            val categoryId: Int, // 25
            @SerializedName("created_at")
            val createdAt: String, // 2014-02-17 08:14:11
            @SerializedName("id")
            val id: Int, // 479
            @SerializedName("name")
            val name: String, // digital art
            @SerializedName("purity")
            val purity: String // sfw
        )

        data class Thumbs(
            @SerializedName("large")
            val large: String, // https://th.wallhaven.cc/lg/ex/exrqrr.jpg
            @SerializedName("original")
            val original: String, // https://th.wallhaven.cc/orig/ex/exrqrr.jpg
            @SerializedName("small")
            val small: String // https://th.wallhaven.cc/small/ex/exrqrr.jpg
        )

        data class Uploader(
            @SerializedName("group")
            val group: String, // Administrator
            @SerializedName("username")
            val username: String // kejsirajbek
        )
    }
}