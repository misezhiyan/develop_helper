import {picrecognizeApi} from "./axiosConfig.js"

export function picrecognizeloglist(data) {
    return picrecognizeApi({
        url: "/picrecognizelog/listLog",
        data: data
    })
}

export function picrecognizelogDel(data) {
    return picrecognizeApi({
        url: "/picrecognizelog/delLog",
        data: data
    })
}