package com.apache.dubbo.cache;

import org.apache.dubbo.cache.Cache;
import org.apache.dubbo.cache.CacheFactory;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Invocation;

/**
 * @author zkn
 * @date 2018/7/21 14:47
 **/
public class CacheFactory$Adaptive implements CacheFactory {

    @Override
    public Cache getCache(URL arg0, Invocation arg1) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        URL url = arg0;
        if (arg1 == null) throw new IllegalArgumentException("invocation == null");
        String methodName = arg1.getMethodName();
        String extName = url.getMethodParameter(methodName, "cache", "lru");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.cache.CacheFactory) name from url(" + url.toString() + ") use keys([cache])");
        CacheFactory extension = (CacheFactory) ExtensionLoader.getExtensionLoader(CacheFactory.class).getExtension(extName);
        return extension.getCache(arg0, arg1);
    }
}
