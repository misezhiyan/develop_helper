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

export function templateList(data = {}) {
    return develophelperApi({
        url: "/template/templateList",
        data: data
    })
}

export function addTemplate(data = {}) {
    return develophelperApi({
        url: "/template/add",
        data: data
    })
}

export function udpTemplate(data = {}) {
    return develophelperApi({
        url: "/template/update",
        data: data
    })
}

export function templateFieldsList(data = {}) {
    return develophelperApi({
        url: "/template/templateFieldsList",
        data: data
    })
}

export function templateFieldAdd(data = {}) {
    return develophelperApi({
        url: "/template/templateFieldAdd",
        data: data
    })
}

export function showTemplateResult(data = {}) {
    return develophelperApi({
        url: "/template/showTemplateResult",
        data: data
    })
}
