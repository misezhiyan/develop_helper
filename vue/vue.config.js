const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({

    lintOnSave: false,
    outputDir: 'web',
    transpileDependencies: true,

    devServer: {
        // host: 'localhost',
        // https: false,
        port: 8070,
        open: true,
        proxy: {
            '/api': {
                target: 'http://localhost:8071',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                    // '^/': '/'
                }
            },
            '/apipicrecognize/': {
                target: 'http://localhost:108',
                changeOrigin: true,
                pathRewrite: {
                    '^/apipicrecognize/': '/train/'
                }
            },
            '/daydayup/': {
                target: 'http://localhost:8088',
                changeOrigin: true,
                pathRewrite: {
                    '^/daydayup/': '/daydayup/'
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
