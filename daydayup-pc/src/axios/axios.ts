import router from "@/router";
import axios from "axios";
import { useStore } from 'vuex'

// const baseUrl = 'http://localhost:8072/'
const baseUrl = '/api'

// 基础功能信息
// 实例
const daydayupInstance = axios.create({
    baseURL: baseUrl
})

// 请求拦截
daydayupInstance.interceptors.request.use(
    (config) => {
        // const store = useStore();
        // if (store.user && store.user.token && config.headers) {
        //     config.headers['Authorization'] = `Bearer ${store.user?.token}`
        //     console.log(config.headers.Authorization)
        // }
        return config
    },
    (err) => Promise.reject(err)
)

// 响应拦截
daydayupInstance.interceptors.response.use(
    (res) => {
        if (res.status != 200) {
            return Promise.reject("通信失败")
        }
        return Promise.resolve(res.data);
    },
    (err) => {
        return Promise.reject("异常")
    }
)

// authApi
const daydayupApi = (url: string, data: {}, method: string, headers: {}) => {

    if (!method) {
        method = 'post'
    }

    return new Promise((resolve, reject) => {
        daydayupInstance.request({ method: method, data: data, headers: headers, url: url }).then(
            (response) => {
                resolve(response)
            }
        ).catch((err) => {
            reject(err)
        })
    })
}

export { daydayupApi }