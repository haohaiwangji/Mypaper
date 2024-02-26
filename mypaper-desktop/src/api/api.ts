import request from "@/utils/req.ts";

export default {
    //获取首页壁纸
    getRandomImg(params: object, urlPath: string | null) {
        return request({url: `/${urlPath}/getIndexImg`, method: "get", params})
    },
    //获取壁纸详情
    getImgInfo(params: object, urlPath?: string | null) {
        return request({url: `/${urlPath}/getImgInfo`, method: "get", params})
    },
    //获取排行榜数据
    getTopListImg(params: object) {
        return request({url: `/wall/getTopListImg`, method: "get", params})
    },
    //获取壁纸数据
    getImgData(params: object, urlPath1?: string | null, urlPath2?: string | null) {
        return request({url: `/${urlPath1}/${urlPath2}`, method: "get", params})
    },
    //ai绘画接口
    getAiImg(aiText?: string | null, modelValue?: string | null) {
        return `https://ai.furrybox.cn/api.php?de=${aiText}&mo=${modelValue}&width=960&height=540`
    },
}
