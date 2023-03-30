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

export function getTableList(data = {}) {
    return develophelperApi({
        url: "/dbconnect/getTableList",
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

export function addProject(data = {}) {
    return develophelperApi({
        url: "/project/add",
        data: data
    })
}

export function updateProject(data = {}) {
    return develophelperApi({
        url: "/project/update",
        data: data
    })
}

export function delProject(data = {}) {
    return develophelperApi({
        url: "/project/del",
        data: data
    })
}

export function projectList(data = {}) {
    return develophelperApi({
        url: "/project/list",
        data: data
    })
}

export function addProjectModule(data = {}) {
    return develophelperApi({
        url: "/project/addModule",
        data: data
    })
}

export function updProjectModule(data = {}) {
    return develophelperApi({
        url: "/project/updModule",
        data: data
    })
}

export function delProjectModule(data = {}) {
    return develophelperApi({
        url: "/project/delModule",
        data: data
    })
}

export function projModulesList(data = {}) {
    return develophelperApi({
        url: "/project/projModulesList",
        data: data
    })
}

export function projectComponentList(data = {}) {
    return develophelperApi({
        url: "/project/projComponentList",
        data: data
    })
}

export function addProjectComponent(data = {}) {
    return develophelperApi({
        url: "/project/addComponent",
        data: data
    })
}

export function updProjectComponent(data = {}) {
    return develophelperApi({
        url: "/project/updComponent",
        data: data
    })
}

export function delProjectComponent(data = {}) {
    return develophelperApi({
        url: "/project/delComponent",
        data: data
    })
}

export function generatePolicyList(data = {}) {
    return develophelperApi({
        url: "/generatePolicy/list",
        data: data
    })
}

export function addGeneratePolicy(data = {}) {
    return develophelperApi({
        url: "/generatePolicy/add",
        data: data
    })
}

export function delGeneratePolicy(data = {}) {
    return develophelperApi({
        url: "/generatePolicy/del",
        data: data
    })
}

export function generatePolicyDetailList(data = {}) {
    return develophelperApi({
        url: "/generatePolicy/detailList",
        data: data
    })
}

export function addGeneratePolicyDetail(data = {}) {
    return develophelperApi({
        url: "/generatePolicy/addDetail",
        data: data
    })
}

export function delGeneratePolicyDetail(data = {}) {
    return develophelperApi({
        url: "/generatePolicy/delDetail",
        data: data
    })
}

export function updGeneratePolicyDetail(data = {}) {
    return develophelperApi({
        url: "/generatePolicy/updDetail",
        data: data
    })
}

export function generateFiles(data = {}) {
    return develophelperApi({
        url: "/project/generateFiles",
        data: data
    })
}