import axios from "axios";

// axios.defaults.headers.post['Content-Type'] = 'application/json'
const develophelperInstance = axios.create({
    // baseURL: process.env.VUE_APP_BASE_API, // 请求前置
    // baseURL: 'http://localhost:8071', // 请求前置
    baseURL: '/api/', // 请求前置
    // timeout: 60000, // 超时
    // headers: {
    //     'Content-type': 'application/json'
    //     // 'token': 'testToken',
    //     // 'X-Requested-With': 'XMLHttpRequest'
    // },
    withCredentials: true// 异步请求携带cookie
})

// 拦截器
develophelperInstance.interceptors.request.use(
    function (config) {
        return config;
    },
    function (error) {
        return Promise.reject(error);
    }
)

// 响应拦截器
// develophelperInstance.interceptors.response.use(
//     function (response) {
//         const resCode = response.data.resCode
//         if('0000'!= resCode){
//             return
//         }
//         return new Promise(response.data)
//     },
//     function (error) {
//         return error
//     }
// )

export function develophelperApi({url, data = {}, method = 'post', headers = {}}) {
    return new Promise((resolve, reject) => {
        develophelperInstance.request({method, data, headers, url}).then((response) => {
            resolve(response.data);
        }).catch((error) => {
            reject(error);
        })
    })
}