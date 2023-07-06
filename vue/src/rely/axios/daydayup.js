import {daydayupInstanceApi} from "./axiosConfig.js"

export function saveStudent(data) {
    return daydayupInstanceApi({
        url: "/student/add",
        data: data
    })
}

export function studentList(data) {
    return daydayupInstanceApi({
        url: "/student/list",
        data: data
    })
}