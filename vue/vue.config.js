const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({

    transpileDependencies: true,

    devServer: {
        host: 'localhost',
        https: false,
        port: 8070,
        open: true,
        proxy: {
            '/api/': {
                target: 'http://localhost:8071',
                changeOrigin: true,
                pathRewrite: {
                    '^/api/': ''
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
