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

export function unmatchFeatureList(data) {
    return picrecognizeApi({
        url: "/picrecognizefeature/unmatchFeatureList",
        data: data
    })
}

export function tranFeatureToPic(data) {
    return picrecognizeApi({
        url: "/picrecognizefeature/featureToPic",
        data: data
    })
}

export function matchFeature(data) {
    return picrecognizeApi({
        url: "/picrecognizefeature/matchFeature",
        data: data
    })
}

export function delFeatureLog(data) {
    return picrecognizeApi({
        url: "/picrecognizefeature/delLog",
        data: data
    })
}