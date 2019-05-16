package com.apache.dubbo.common.threadpool;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.threadpool.ThreadPool;

/**
 * @author zkn
 * @date 2018/7/21 14:47
 **/
public class ThreadPool$Adaptive implements ThreadPool {

    @Override
    public java.util.concurrent.Executor getExecutor(URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getParameter("threadpool", "fixed");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.common.threadpool.ThreadPool) name from url(" + url.toString() + ") use keys([threadpool])");
        ThreadPool extension = (ThreadPool) ExtensionLoader.getExtensionLoader(ThreadPool.class).getExtension(extName);
        return extension.getExecutor(arg0);
    }
}