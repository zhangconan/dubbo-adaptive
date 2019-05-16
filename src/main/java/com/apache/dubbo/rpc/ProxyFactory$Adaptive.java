package com.apache.dubbo.rpc;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.ProxyFactory;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author zkn
 */
public class ProxyFactory$Adaptive implements ProxyFactory {

    @Override
    public java.lang.Object getProxy(Invoker arg0) throws RpcException {
        if (arg0 == null) throw new IllegalArgumentException("com.apache.dubbo.rpc.Invoker argument == null");
        if (arg0.getUrl() == null)
            throw new IllegalArgumentException("com.apache.dubbo.rpc.Invoker argument getUrl() == null");
        URL url = arg0.getUrl();
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.rpc.ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        ProxyFactory extension = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getProxy(arg0);
    }

    @Override
    public Invoker getInvoker(java.lang.Object arg0, java.lang.Class arg1, URL arg2) throws RpcException {
        if (arg2 == null) throw new IllegalArgumentException("url == null");
        URL url = arg2;
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.rpc.ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        ProxyFactory extension = (ProxyFactory) ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getInvoker(arg0, arg1, arg2);
    }

    @Override
    public <T> T getProxy(Invoker<T> invoker, boolean b) throws RpcException {
        return null;
    }
}