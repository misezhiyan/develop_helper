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
                    // target: 'http://localhost:8071',
                    target: 'http://192.168.3.248:8072',
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
