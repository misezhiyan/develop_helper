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

export function saveSchedule(data) {
    return daydayupInstanceApi({
        url: "/schedule/add",
        data: data
    })
}

export function scheduleList(data) {
    return daydayupInstanceApi({
        url: "/schedule/list",
        data: data
    })
}

export function delSchedule(data) {
    return daydayupInstanceApi({
        url: "/schedule/del",
        data: data
    })
}

export function scheduleInfoList(data) {
    return daydayupInstanceApi({
        url: "/schedule/infoList",
        data: data
    })
}

export function scheduleOccupyList(data) {
    return daydayupInstanceApi({
        url: "/schedule/occupyList",
        data: data
    })
}

export function scheduleOccupy(data) {
    return daydayupInstanceApi({
        url: "/schedule/occupy",
        data: data
    })
}
