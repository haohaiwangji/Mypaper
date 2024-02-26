package com.haohai.mypaper.utils


/**
 *响应参数
 **/
data class Result<T>(
    /**
     * 响应状态码
     * @param code 参数
     **/
    val code: Int,
    /**
     * 响应信息
     * @param message 参数
     **/
    val message: String,
    /**
     * 响应数据
     * @param data 参数
     **/
    val data: T? = null,
    /**
     * 分页信息
     * @param page 参数
     **/
//    val page:T?=null
)

class ResultApi private constructor() {
    companion object {
        //返回成功
        fun <T> ok(data: T,page: T? = null): Result<T> {
//            return Result(ResultCodeEnum.SUCCESS.code, ResultCodeEnum.SUCCESS.message, data,page)
            return Result(ResultCodeEnum.SUCCESS.code, ResultCodeEnum.SUCCESS.message, data)
        }
        // 返回失败
        fun <T> fail(data: T,page: T? = null): Result<T> {
//            return Result(ResultCodeEnum.FAIL.code, ResultCodeEnum.FAIL.message, data,page)
            return Result(ResultCodeEnum.FAIL.code, ResultCodeEnum.FAIL.message, data)
        }
        //返回数值时判断
        fun <T> toResult(rows: Int): Result<T?> {
            return if (rows > 0) ok(null) else fail(null)
        }
        //自定义返回数据
        fun <T> ResultData(code: Int, message: String,data:T,page: T? = null): Result<T> {
//            return Result(code,message, data,page)
            return Result(code,message, data)
        }
        //分页携带
//        fun <T> ResultData(code: Int, message: String,data:T): Result<T> {
//            return Result(code,message, data)
//        }
    }
}