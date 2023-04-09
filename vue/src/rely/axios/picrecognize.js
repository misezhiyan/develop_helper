import {picrecognizeApi} from "./axiosConfig.js"

export function picrecognizeloglist(data) {
    return picrecognizeApi({
        url: "/picrecognizelog/list",
        data: data
    })
}