import axios, { AxiosRequestConfig } from 'axios';


// 定义全局默认配置
const defaultConfig: AxiosRequestConfig = {
    baseURL: 'http://127.0.0.1:8080', // 设置基础 URL
    // baseURL: 'http://hk-02.starryfrp.com:4721', // 设置基础 URL
    timeout: 50000, // 可选，设置超时时间
};

//1. 创建axios对象
const service = axios.create(defaultConfig);

//2. 请求拦截器
service.interceptors.request.use(config => {
    return config;
}, error => {
    Promise.reject(error);
});

//3. 响应拦截器
service.interceptors.response.use(response => {
    //判断code码
    return response.data;
}, error => {
    return Promise.reject(error);
});

export default service;
