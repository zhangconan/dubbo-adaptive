package com.apache.dubbo.rpc.cluster;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.cluster.Router;
import org.apache.dubbo.rpc.cluster.RouterFactory;

/**
 * @author zkn
 * @date 2018/7/21 14:43
 **/
public class RouterFactory$Adaptive implements RouterFactory {
    @Override
    public Router getRouter(URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getProtocol();
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.rpc.cluster.RouterFactory) name from url(" + url.toString() + ") use keys([protocol])");
        RouterFactory extension = (RouterFactory) ExtensionLoader.getExtensionLoader(RouterFactory.class).getExtension(extName);
        return extension.getRouter(arg0);
    }
}
