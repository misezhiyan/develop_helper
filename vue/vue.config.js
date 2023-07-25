const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({

    lintOnSave: false,
    outputDir: 'dist',
    transpileDependencies: true,

    devServer: {
        // host: 'localhost',
        // https: false,
        port: 8072,
        open: true,
        proxy: {
            '/webapi': {
                target: 'http://localhost:36500/gateway/web',
                changeOrigin: true,
                pathRewrite: {
                    '^/webapi': ''
                }
            },
            '/daydayupapi': {
                target: 'http://localhost:36500/gateway/daydayup',
                changeOrigin: true,
                pathRewrite: {
                    '^/daydayupapi': ''
                }
            },
            '/apipicrecognize': {
                target: 'http://localhost:108',
                changeOrigin: true,
                pathRewrite: {
                    '^/apipicrecognize': '/train'
                }
            },
            // [process.env.VUE_APP_BASE_API]: {
            //     target: 'http://localhost:8071',
            //     changeOrigin: true,
            //     pathRewrite: {
            //         ['^' + process.env.VUE_APP_BASE_API]: ''
            //     }
            // }
        }
    }

})
