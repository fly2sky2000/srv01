module.exports = {
    dev: {
        // Paths
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
        proxyTable: {
            '/api': {
                target: 'http://localhost:8188/srv01', // 接口地址
                changeOrigin: true, // 是否跨域
                pathRewrite: { // 转发
                    '^/srv01': ''
                },
                secure: false 
            },
        }
}
