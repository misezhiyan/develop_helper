export const isMobile = ():boolean => {
    let flag = navigator.userAgent.match(/(phone|pad|pod|iphone|ipod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows phone)/i)
    return flag != null
}