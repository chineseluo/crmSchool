(function() {
    // 配置
    var envir = 'online';
    var configMap = {
        test: {
            appkey: '7f7649871e15c9d5ef4dc18e98d071af',
            url:'https://apptest.netease.im'
        },
        
        pre:{
    		appkey: '7f7649871e15c9d5ef4dc18e98d071af',
    		url:'http://preapp.netease.im:8184'
        },
        online: {
           appkey: '7f7649871e15c9d5ef4dc18e98d071af',
           url:'https://app.netease.im'
        }
    };
    window.CONFIG = configMap[envir];
    // 是否开启订阅服务
    window.CONFIG.openSubscription = true
}())