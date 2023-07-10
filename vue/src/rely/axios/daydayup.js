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

export function saveTeacher(data) {
    return daydayupInstanceApi({
        url: "/teacher/add",
        data: data
    })
}

export function teacherList(data) {
    return daydayupInstanceApi({
        url: "/teacher/list",
        data: data
    })
}