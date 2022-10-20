import {develophelperApi} from "./axiosConfig.js"

export function saveconnect(data) {
    return develophelperApi({
        url: "/dbconnect/saveconnect",
        data: data
    })
}

export function testConnect(data) {
    return develophelperApi({
        url: "/dbconnect/testconnect",
        data: data
    })
}

export function getDbList(data = {}) {
    return develophelperApi({
        url: "/dbconnect/getDbList",
        data: data
    })
}

export function getMenuList(data = {}) {
    return develophelperApi({
        url: "/menu/getMenuList",
        data: data
    })
}

export function addMenu(data = {}) {
    return develophelperApi({
        url: "/menu/addMenu",
        data: data
    })
}

export function delMenu(data = {}) {
    return develophelperApi({
        url: "/menu/delMenu",
        data: data
    })
}

