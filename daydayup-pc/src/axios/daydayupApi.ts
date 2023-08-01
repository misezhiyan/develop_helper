import { daydayupApi } from './axios'

export const login = (data: {}) => {
    return daydayupApi('/login/login', data, 'post', {})
 }


export const teacherList = (data: {}) => {
   return daydayupApi('/teacher/list', data, 'post', {})
}